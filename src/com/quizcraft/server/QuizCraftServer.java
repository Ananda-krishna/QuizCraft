package com.quizcraft.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class QuizCraftServer {

    private static final int PORT = 8080;
    private static final String STATIC_DIR = "resources/static";
    private static final String DATA_DIR = "resources/data";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // Static files handler
        server.createContext("/", new StaticFileHandler());

        // API handlers
        server.createContext("/api/quizzes", new QuizApiHandler());

        server.setExecutor(null); // default executor
        System.out.println("\n⛏️  QuizCraft Server Started!");
        System.out.println("✅  Running at http://localhost:" + PORT);
        System.out.println("📂  Serving files from: " + STATIC_DIR);
        server.start();
    }

    static class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            if (path.equals("/")) {
                path = "/index.html";
            }

            File file = new File(STATIC_DIR + path);
            if (!file.exists() || file.isDirectory()) {
                // If not found, serve index.html for SPA support or just 404
                file = new File(STATIC_DIR + "/index.html");
            }

            if (file.exists()) {
                byte[] content = Files.readAllBytes(file.toPath());
                String contentType = getContentType(path);
                exchange.getResponseHeaders().set("Content-Type", contentType);
                exchange.sendResponseHeaders(200, content.length);
                OutputStream os = exchange.getResponseBody();
                os.write(content);
                os.close();
            } else {
                String response = "404 Not Found";
                exchange.sendResponseHeaders(404, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }

        private String getContentType(String path) {
            if (path.endsWith(".html")) return "text/html";
            if (path.endsWith(".css")) return "text/css";
            if (path.endsWith(".js")) return "application/javascript";
            if (path.endsWith(".png")) return "image/png";
            if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return "image/jpeg";
            if (path.endsWith(".json")) return "application/json";
            if (path.endsWith(".svg")) return "image/svg+xml";
            return "text/plain";
        }
    }

    static class QuizApiHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath();

            if (method.equalsIgnoreCase("GET")) {
                if (path.startsWith("/api/quizzes/category/")) {
                    String category = path.substring("/api/quizzes/category/".length());
                    handleGetQuizzesByCategory(exchange, category);
                } else {
                    handleGetAllQuizzes(exchange);
                }
            } else if (method.equalsIgnoreCase("POST")) {
                handleCreateQuiz(exchange);
            }
        }

        private void handleGetAllQuizzes(HttpExchange exchange) throws IOException {
            File[] files = new File(DATA_DIR).listFiles((dir, name) -> name.endsWith(".json"));
            StringBuilder json = new StringBuilder("[");
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    json.append(new String(Files.readAllBytes(files[i].toPath())));
                    if (i < files.length - 1) json.append(",");
                }
            }
            json.append("]");
            sendJsonResponse(exchange, json.toString());
        }

        private void handleGetQuizzesByCategory(HttpExchange exchange, String category) throws IOException {
            // Simple filter: read all files and check category field
            // Note: This is a very basic "manual" JSON parsing approach since we don't have Jackson/Gson
            File[] files = new File(DATA_DIR).listFiles((dir, name) -> name.endsWith(".json"));
            StringBuilder json = new StringBuilder("[");
            boolean first = true;
            if (files != null) {
                for (File file : files) {
                    String content = new String(Files.readAllBytes(file.toPath()));
                    // Stricter check for "category": "CategoryName" to avoid partial matches
                    String searchStr = "\"category\": \"" + category + "\"";
                    String searchStrNoSpace = "\"category\":\"" + category + "\"";
                    
                    if (content.contains(searchStr) || content.contains(searchStrNoSpace)) {
                        if (!first) json.append(",");
                        json.append(content);
                        first = false;
                    }
                }
            }
            json.append("]");
            sendJsonResponse(exchange, json.toString());
        }

        private void handleCreateQuiz(HttpExchange exchange) throws IOException {
            InputStream is = exchange.getRequestBody();
            String content = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines().collect(Collectors.joining("\n"));
            
            String id = java.util.UUID.randomUUID().toString();
            // Inject ID into JSON manually (crude but works for this scope)
            if (!content.contains("\"id\"")) {
                content = content.replaceFirst("\\{", "{\"id\":\"" + id + "\",");
            }
            
            Files.write(Paths.get(DATA_DIR + "/" + id + ".json"), content.getBytes());
            
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(201, content.length());
            OutputStream os = exchange.getResponseBody();
            os.write(content.getBytes());
            os.close();
        }

        private void sendJsonResponse(HttpExchange exchange, String json) throws IOException {
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }
}
