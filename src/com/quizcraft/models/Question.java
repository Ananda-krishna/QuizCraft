package com.quizcraft.models;

import java.util.List;

public class Question {
    private String text;
    private List<String> options;
    private int correctOptionIndex;
    private String difficulty; // Added difficulty field

    public Question(String text, List<String> options, int correctOptionIndex, String difficulty) {
        this.text = text;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
        this.difficulty = difficulty;
    }

    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"text\": \"").append(escape(text)).append("\",");
        sb.append("\"options\": [");
        for (int i = 0; i < options.size(); i++) {
            sb.append("\"").append(escape(options.get(i))).append("\"");
            if (i < options.size() - 1) sb.append(",");
        }
        sb.append("],");
        sb.append("\"correctOptionIndex\": ").append(correctOptionIndex).append(",");
        sb.append("\"difficulty\": \"").append(difficulty).append("\"");
        sb.append("}");
        return sb.toString();
    }

    private String escape(String input) {
        if (input == null) return "";
        return input.replace("\"", "\\\"").replace("\n", "\\n");
    }

    // Getters
    public String getText() { return text; }
    public List<String> getOptions() { return options; }
    public int getCorrectOptionIndex() { return correctOptionIndex; }
    public String getDifficulty() { return difficulty; }
}
