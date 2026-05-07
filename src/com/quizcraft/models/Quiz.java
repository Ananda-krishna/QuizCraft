package com.quizcraft.models;

import java.util.List;

public class Quiz {
    private String id;
    private String title;
    private String category;
    private String description;
    private List<Question> questions;

    public Quiz(String id, String title, String category, String description, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.questions = questions;
    }

    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"id\": \"").append(id).append("\",");
        sb.append("\"title\": \"").append(title).append("\",");
        sb.append("\"category\": \"").append(category).append("\",");
        sb.append("\"description\": \"").append(description).append("\",");
        sb.append("\"questions\": [");
        for (int i = 0; i < questions.size(); i++) {
            sb.append(questions.get(i).toJson());
            if (i < questions.size() - 1) sb.append(",");
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public List<Question> getQuestions() { return questions; }
}
