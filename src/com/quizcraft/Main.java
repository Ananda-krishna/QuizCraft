package com.quizcraft;

import com.quizcraft.server.QuizCraftServer;
import java.awt.Desktop;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                QuizCraftServer.main(args);
            } catch (Exception e) {
                System.err.println("❌  Server failed to start: " + e.getMessage());
            }
        }).start();

        // Wait a moment for server to bind
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // Auto-open browser
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                System.out.println("🌐  Opening browser to http://localhost:8080...");
                Desktop.getDesktop().browse(new URI("http://localhost:8080"));
            } else {
                System.out.println("👉  Please open your browser to http://localhost:8080");
            }
        } catch (Exception e) {
            System.out.println("👉  Please open your browser to http://localhost:8080");
        }
    }
}
