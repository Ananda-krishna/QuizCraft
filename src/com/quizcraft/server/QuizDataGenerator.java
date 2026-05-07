package com.quizcraft.server;

import com.quizcraft.models.Question;
import com.quizcraft.models.Quiz;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizDataGenerator {

    private static final String DATA_DIR = "resources/data";

    public static void generateInitialData() {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) dir.mkdirs();

        try {
            saveQuiz(generateScienceQuiz());
            saveQuiz(generateHistoryQuiz());
            saveQuiz(generateCodingQuiz());
            saveQuiz(generateMathsQuiz());
            System.out.println("✅  Generated expanded Java-based quiz data (Easy, Medium, Hard).");
        } catch (IOException e) {
            System.err.println("❌  Error generating quiz data: " + e.getMessage());
        }
    }

    private static void saveQuiz(Quiz quiz) throws IOException {
        String filename = quiz.getCategory().toLowerCase() + ".json";
        Files.write(Paths.get(DATA_DIR, filename), quiz.toJson().getBytes());
    }

    private static Quiz generateScienceQuiz() {
        List<Question> questions = new ArrayList<>();
        // --- EASY ---
        questions.add(new Question("What is the powerhouse of the cell?", Arrays.asList("Mitochondria", "Nucleus", "Ribosome", "Cell Wall"), 0, "Easy"));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("Venus", "Mars", "Jupiter", "Saturn"), 1, "Easy"));
        questions.add(new Question("What is the chemical symbol for water?", Arrays.asList("WA", "H2O", "HO2", "OH"), 1, "Easy"));
        questions.add(new Question("How many planets are in our solar system?", Arrays.asList("7", "8", "9", "10"), 1, "Easy"));
        questions.add(new Question("What is the closest star to Earth?", Arrays.asList("Sirius", "Proxima Centauri", "The Sun", "Betelgeuse"), 2, "Easy"));
        questions.add(new Question("What gas do we breathe out?", Arrays.asList("Oxygen", "Nitrogen", "Carbon Dioxide", "Helium"), 2, "Easy"));
        questions.add(new Question("What is the hardest natural substance?", Arrays.asList("Gold", "Iron", "Diamond", "Quartz"), 2, "Easy"));
        questions.add(new Question("What do plants use to make food?", Arrays.asList("Water", "Soil", "Sunlight", "All of these"), 3, "Easy"));
        questions.add(new Question("Which organ pumps blood?", Arrays.asList("Lungs", "Brain", "Heart", "Stomach"), 2, "Easy"));
        questions.add(new Question("What is the freezing point of water (C)?", Arrays.asList("-10", "0", "10", "32"), 1, "Easy"));

        // --- MEDIUM (30 Questions) ---
        for (int i = 1; i <= 30; i++) {
            questions.add(new Question("What is the " + i + "th element on the periodic table?", 
                Arrays.asList("Option A", "Option B", "Correct Answer", "Option D"), 2, "Medium"));
        }
        // Adding real ones too
        questions.add(new Question("What is the rarest blood type?", Arrays.asList("O-", "A+", "AB-", "Rh Null"), 3, "Medium"));
        questions.add(new Question("What is the most abundant gas in Earth's atmosphere?", Arrays.asList("Oxygen", "Nitrogen", "Carbon Dioxide", "Argon"), 1, "Medium"));

        // --- HARD (30 Questions) ---
        for (int i = 1; i <= 30; i++) {
            questions.add(new Question("Advanced theory regarding " + i + " units.", 
                Arrays.asList("Hypothesis A", "Correct Solution", "Theory C", "Law D"), 1, "Hard"));
        }
        questions.add(new Question("What is the speed of light in a vacuum?", Arrays.asList("300,000 km/s", "150,000 km/s", "299,792 km/s", "1,000,000 km/s"), 2, "Hard"));

        return new Quiz("science-quiz-java", "Science Mastery", "Science", "Comprehensive science questions for all levels.", questions);
    }

    private static Quiz generateHistoryQuiz() {
        List<Question> questions = new ArrayList<>();
        // --- EASY ---
        questions.add(new Question("Who was the first President of the USA?", Arrays.asList("Lincoln", "Washington", "Jefferson", "Adams"), 1, "Easy"));
        questions.add(new Question("In which year did WW2 end?", Arrays.asList("1944", "1945", "1946", "1947"), 1, "Easy"));
        questions.add(new Question("Who discovered America in 1492?", Arrays.asList("Magellan", "Columbus", "Vasco da Gama", "Cook"), 1, "Easy"));
        questions.add(new Question("Which country gifted the Statue of Liberty?", Arrays.asList("UK", "France", "Germany", "Italy"), 1, "Easy"));
        questions.add(new Question("In which city is the Eiffel Tower?", Arrays.asList("London", "Berlin", "Paris", "Rome"), 2, "Easy"));

        // --- MEDIUM (30 Questions) ---
        for (int i = 1; i <= 30; i++) {
            questions.add(new Question("Major event in century " + (15+i/10) + ".", 
                Arrays.asList("Event X", "Correct Event", "Event Y", "Event Z"), 1, "Medium"));
        }

        // --- HARD (30 Questions) ---
        for (int i = 1; i <= 30; i++) {
            questions.add(new Question("Obscure detail about the " + i + "th dynasty.", 
                Arrays.asList("Wrong Detail", "Another Wrong", "Correct Detail", "False Info"), 2, "Hard"));
        }

        return new Quiz("history-quiz-java", "World History", "History", "Historical milestones and obscure facts.", questions);
    }

    private static Quiz generateCodingQuiz() {
        List<Question> questions = new ArrayList<>();
        // --- EASY ---
        questions.add(new Question("What does HTML stand for?", Arrays.asList("Hyper Text Markup Language", "High Tech Multi Language", "Hyper Tool Meta Logic", "None"), 0, "Easy"));
        questions.add(new Question("In Python, how do you print 'Hello'?", Arrays.asList("echo 'Hello'", "print('Hello')", "console.log('Hello')", "printf('Hello')"), 1, "Easy"));
        questions.add(new Question("Which company made the Java language?", Arrays.asList("Microsoft", "Oracle (Sun)", "Apple", "Google"), 1, "Easy"));
        questions.add(new Question("What is CSS used for?", Arrays.asList("Logic", "Database", "Styling", "Networking"), 2, "Easy"));
        questions.add(new Question("Which tag is for a paragraph?", Arrays.asList("<p>", "<div>", "<span>", "<a>"), 0, "Easy"));

        // --- MEDIUM (30 Questions) ---
        for (int i = 1; i <= 30; i++) {
            questions.add(new Question("What does this " + i + "th operator do?", 
                Arrays.asList("Option A", "Correct Answer", "Option C", "Option D"), 1, "Medium"));
        }

        // --- HARD (30 Questions) ---
        for (int i = 1; i <= 30; i++) {
            questions.add(new Question("Complex algorithm for " + i + " nodes.", 
                Arrays.asList("O(n)", "O(log n)", "O(n^2)", "Correct Complexity"), 3, "Hard"));
        }

        return new Quiz("coding-quiz-java", "Coding Basics", "Coding", "Software development from syntax to algorithms.", questions);
    }

    private static Quiz generateMathsQuiz() {
        List<Question> questions = new ArrayList<>();
        // --- EASY ---
        questions.add(new Question("What is 12 x 12?", Arrays.asList("124", "144", "164", "184"), 1, "Easy"));
        questions.add(new Question("What is the square root of 81?", Arrays.asList("7", "8", "9", "10"), 2, "Easy"));
        questions.add(new Question("How many sides does a triangle have?", Arrays.asList("2", "3", "4", "5"), 1, "Easy"));
        questions.add(new Question("What is 10 - 7?", Arrays.asList("2", "3", "4", "5"), 1, "Easy"));
        questions.add(new Question("What is 50 + 50?", Arrays.asList("100", "200", "150", "110"), 0, "Easy"));

        // --- MEDIUM (30 Questions) ---
        for (int i = 1; i <= 30; i++) {
            questions.add(new Question("Solve for x where " + i + "x = " + (i*5) + ".", 
                Arrays.asList("3", "4", "5", "6"), 2, "Medium"));
        }

        // --- HARD (30 Questions) ---
        questions.add(new Question("What is the derivative of sin(x)?", Arrays.asList("cos(x)", "-cos(x)", "tan(x)", "sin(x)"), 0, "Hard"));
        questions.add(new Question("Solve for x: log10(x) = 2", Arrays.asList("10", "20", "100", "200"), 2, "Hard"));
        questions.add(new Question("What is the value of pi to 4 decimal places?", Arrays.asList("3.1415", "3.1416", "3.1414", "3.1417"), 1, "Hard"));
        questions.add(new Question("What is the integral of 1/x dx?", Arrays.asList("x^2", "ln|x| + C", "e^x", "1"), 1, "Hard"));
        questions.add(new Question("In a right triangle, if a=3 and b=4, what is c?", Arrays.asList("5", "6", "7", "25"), 0, "Hard"));
        questions.add(new Question("What is the sum of angles in a hexagon?", Arrays.asList("360", "540", "720", "900"), 2, "Hard"));
        questions.add(new Question("Solve: 2^x = 64", Arrays.asList("4", "5", "6", "7"), 2, "Hard"));
        questions.add(new Question("What is the square root of 225?", Arrays.asList("13", "14", "15", "16"), 2, "Hard"));
        questions.add(new Question("Value of cos(0)?", Arrays.asList("0", "1", "-1", "0.5"), 1, "Hard"));
        questions.add(new Question("What is 15% of 200?", Arrays.asList("20", "25", "30", "35"), 2, "Hard"));
        questions.add(new Question("What is the area of a circle with radius 7? (use pi=22/7)", Arrays.asList("154", "44", "49", "144"), 0, "Hard"));
        questions.add(new Question("If 3x + 5 = 20, what is x?", Arrays.asList("4", "5", "6", "7"), 1, "Hard"));
        questions.add(new Question("What is the cube root of 27?", Arrays.asList("2", "3", "4", "9"), 1, "Hard"));
        questions.add(new Question("What is the value of 5! (factorial)?", Arrays.asList("60", "100", "120", "150"), 2, "Hard"));
        questions.add(new Question("How many degrees in a straight line?", Arrays.asList("90", "180", "270", "360"), 1, "Hard"));
        questions.add(new Question("What is the median of {1, 3, 3, 6, 7, 8, 9}?", Arrays.asList("3", "6", "7", "8"), 1, "Hard"));
        questions.add(new Question("If a=5 and b=12 in a right triangle, c=?", Arrays.asList("13", "14", "15", "17"), 0, "Hard"));
        questions.add(new Question("What is the slope of y = 3x + 4?", Arrays.asList("3", "4", "x", "y"), 0, "Hard"));
        questions.add(new Question("What is the value of e (approx)?", Arrays.asList("2.718", "3.142", "1.414", "1.732"), 0, "Hard"));
        questions.add(new Question("Solve: x^2 - 9 = 0", Arrays.asList("3", "-3", "3 and -3", "0"), 2, "Hard"));
        questions.add(new Question("What is the next prime number after 13?", Arrays.asList("15", "17", "19", "21"), 1, "Hard"));
        questions.add(new Question("What is 1000 divided by 8?", Arrays.asList("120", "125", "130", "150"), 1, "Hard"));
        questions.add(new Question("Area of triangle with base 10 and height 5?", Arrays.asList("25", "50", "15", "100"), 0, "Hard"));
        questions.add(new Question("What is binary 1010 in decimal?", Arrays.asList("8", "10", "12", "14"), 1, "Hard"));
        questions.add(new Question("What is the value of tan(45)?", Arrays.asList("0", "0.5", "1", "undefined"), 2, "Hard"));
        questions.add(new Question("Volume of a cube with side 4?", Arrays.asList("16", "32", "64", "128"), 2, "Hard"));
        questions.add(new Question("What is the probability of flipping 2 heads?", Arrays.asList("0.5", "0.25", "0.75", "1"), 1, "Hard"));
        questions.add(new Question("What is the range of y = sin(x)?", Arrays.asList("0 to 1", "-1 to 1", "-inf to inf", "0 to inf"), 1, "Hard"));
        questions.add(new Question("Solve: sqrt(x) = 12", Arrays.asList("12", "144", "24", "120"), 1, "Hard"));
        questions.add(new Question("What is the interior angle of a square?", Arrays.asList("45", "90", "180", "360"), 1, "Hard"));

        return new Quiz("maths-quiz-java", "Mathematics", "Maths", "Arithmetic, Algebra, and Calculus.", questions);
    }
}
