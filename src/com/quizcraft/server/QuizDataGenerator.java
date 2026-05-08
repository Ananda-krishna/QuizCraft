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
        questions.add(new Question("Which element has the atomic number 1?", Arrays.asList("Helium", "Hydrogen", "Lithium", "Oxygen"), 1, "Medium"));
        questions.add(new Question("What is the most abundant gas in Earth's atmosphere?", Arrays.asList("Oxygen", "Nitrogen", "Carbon Dioxide", "Argon"), 1, "Medium"));
        questions.add(new Question("How many bones are in the adult human body?", Arrays.asList("206", "205", "210", "201"), 0, "Medium"));
        questions.add(new Question("What is the chemical symbol for Gold?", Arrays.asList("Ag", "Gd", "Au", "Fe"), 2, "Medium"));
        questions.add(new Question("Which planet has the most moons?", Arrays.asList("Mars", "Saturn", "Jupiter", "Neptune"), 1, "Medium"));
        questions.add(new Question("What is the speed of sound?", Arrays.asList("343 m/s", "299 m/s", "1000 m/s", "500 m/s"), 0, "Medium"));
        questions.add(new Question("What is the main component of the Sun?", Arrays.asList("Helium", "Oxygen", "Hydrogen", "Carbon"), 2, "Medium"));
        questions.add(new Question("Which blood type is the universal donor?", Arrays.asList("A+", "B-", "AB+", "O-"), 3, "Medium"));
        questions.add(new Question("What is the largest organ in the human body?", Arrays.asList("Liver", "Brain", "Skin", "Heart"), 2, "Medium"));
        questions.add(new Question("Which gas is responsible for the smell of rotten eggs?", Arrays.asList("Oxygen", "Hydrogen Sulfide", "Ammonia", "Methane"), 1, "Medium"));
        questions.add(new Question("What is the center of an atom called?", Arrays.asList("Proton", "Electron", "Nucleus", "Neutron"), 2, "Medium"));
        questions.add(new Question("What is the boiling point of water in Fahrenheit?", Arrays.asList("100", "200", "212", "180"), 2, "Medium"));
        questions.add(new Question("Which metal is liquid at room temperature?", Arrays.asList("Iron", "Mercury", "Lead", "Zinc"), 1, "Medium"));
        questions.add(new Question("What is the largest planet in our solar system?", Arrays.asList("Earth", "Saturn", "Jupiter", "Uranus"), 2, "Medium"));
        questions.add(new Question("Which vitamin is produced when the human body is exposed to sunlight?", Arrays.asList("Vitamin A", "Vitamin B12", "Vitamin C", "Vitamin D"), 3, "Medium"));
        questions.add(new Question("What is the chemical symbol for Sodium?", Arrays.asList("S", "So", "Na", "Ni"), 2, "Medium"));
        questions.add(new Question("What part of the plant conducts photosynthesis?", Arrays.asList("Root", "Stem", "Leaf", "Flower"), 2, "Medium"));
        questions.add(new Question("Which planet is known as the Morning Star?", Arrays.asList("Mars", "Venus", "Mercury", "Jupiter"), 1, "Medium"));
        questions.add(new Question("What is the most common element in the universe?", Arrays.asList("Oxygen", "Hydrogen", "Carbon", "Helium"), 1, "Medium"));
        questions.add(new Question("How many states of matter are there (basic)?", Arrays.asList("2", "3", "4", "5"), 1, "Medium"));
        questions.add(new Question("What is the study of mushrooms called?", Arrays.asList("Botany", "Mycology", "Biology", "Zoology"), 1, "Medium"));
        questions.add(new Question("Which instrument measures atmospheric pressure?", Arrays.asList("Thermometer", "Barometer", "Hygrometer", "Anemometer"), 1, "Medium"));
        questions.add(new Question("What is the powerhouse of the cell?", Arrays.asList("Mitochondria", "Nucleus", "Ribosome", "Vacuole"), 0, "Medium"));
        questions.add(new Question("What is the chemical symbol for Silver?", Arrays.asList("Si", "Sl", "Ag", "Au"), 2, "Medium"));
        questions.add(new Question("Which bird is the only one that can fly backwards?", Arrays.asList("Eagle", "Parrot", "Hummingbird", "Owl"), 2, "Medium"));
        questions.add(new Question("What is the chemical symbol for Iron?", Arrays.asList("Ir", "In", "Fe", "I"), 2, "Medium"));
        questions.add(new Question("Which planet is closest to the Sun?", Arrays.asList("Venus", "Mars", "Mercury", "Earth"), 2, "Medium"));
        questions.add(new Question("What is the unit of electrical resistance?", Arrays.asList("Volt", "Ampere", "Ohm", "Watt"), 2, "Medium"));
        questions.add(new Question("What is the largest species of shark?", Arrays.asList("Great White", "Hammerhead", "Whale Shark", "Bull Shark"), 2, "Medium"));
        questions.add(new Question("What is the chemical symbol for Potassium?", Arrays.asList("P", "Po", "K", "Pt"), 2, "Medium"));

        // --- HARD (30 Questions) ---
        questions.add(new Question("What is the speed of light in a vacuum?", Arrays.asList("300,000 km/s", "150,000 km/s", "299,792 km/s", "1,000,000 km/s"), 2, "Hard"));
        questions.add(new Question("What is the chemical formula for Sulfuric Acid?", Arrays.asList("H2SO3", "H2SO4", "HCl", "HNO3"), 1, "Hard"));
        questions.add(new Question("Which scientist proposed the theory of General Relativity?", Arrays.asList("Newton", "Tesla", "Einstein", "Hawking"), 2, "Hard"));
        questions.add(new Question("What is the absolute zero temperature in Celsius?", Arrays.asList("-100.5", "-273.15", "-300", "-250.25"), 1, "Hard"));
        questions.add(new Question("What is the half-life of Carbon-14?", Arrays.asList("1,000 years", "5,730 years", "10,500 years", "2,500 years"), 1, "Hard"));
        questions.add(new Question("Which particle in an atom has a negative charge?", Arrays.asList("Proton", "Neutron", "Electron", "Positron"), 2, "Hard"));
        questions.add(new Question("What is the most electronegative element?", Arrays.asList("Oxygen", "Chlorine", "Fluorine", "Nitrogen"), 2, "Hard"));
        questions.add(new Question("Who discovered Penicillin?", Arrays.asList("Louis Pasteur", "Alexander Fleming", "Marie Curie", "Gregor Mendel"), 1, "Hard"));
        questions.add(new Question("What is the escape velocity from Earth?", Arrays.asList("5 km/s", "11.2 km/s", "25.5 km/s", "40.2 km/s"), 1, "Hard"));
        questions.add(new Question("What is the primary gas found in the atmosphere of Venus?", Arrays.asList("Oxygen", "Nitrogen", "Carbon Dioxide", "Sulfur Dioxide"), 2, "Hard"));
        questions.add(new Question("Which law states that for every action there is an equal and opposite reaction?", Arrays.asList("Newton's 1st Law", "Newton's 2nd Law", "Newton's 3rd Law", "Kepler's Law"), 2, "Hard"));
        questions.add(new Question("What is the chemical symbol for Tungsten?", Arrays.asList("T", "Tu", "W", "Tg"), 2, "Hard"));
        questions.add(new Question("How many heart chambers does a cockroach have?", Arrays.asList("2", "4", "12", "13"), 3, "Hard"));
        questions.add(new Question("What is the value of the gravitational constant (G)?", Arrays.asList("9.81", "6.674e-11", "3.141", "1.602e-19"), 1, "Hard"));
        questions.add(new Question("Which layer of the atmosphere contains the ozone layer?", Arrays.asList("Troposphere", "Stratosphere", "Mesosphere", "Exosphere"), 1, "Hard"));
        questions.add(new Question("What is the process of converting a liquid to a gas called?", Arrays.asList("Sublimation", "Condensation", "Evaporation", "Freezing"), 2, "Hard"));
        questions.add(new Question("Which element is used in nuclear reactors as fuel?", Arrays.asList("Uranium", "Plutonium", "Thorium", "All of these"), 3, "Hard"));
        questions.add(new Question("What is the study of fossils called?", Arrays.asList("Archeology", "Paleontology", "Geology", "Anthropology"), 1, "Hard"));
        questions.add(new Question("What is the pH level of pure water?", Arrays.asList("0", "5", "7", "14"), 2, "Hard"));
        questions.add(new Question("Which noble gas is often used in lighting?", Arrays.asList("Helium", "Neon", "Argon", "Xenon"), 1, "Hard"));
        questions.add(new Question("What is the name of the largest volcano in our solar system?", Arrays.asList("Mount Everest", "Mauna Kea", "Olympus Mons", "Vesuvius"), 2, "Hard"));
        questions.add(new Question("What is the unit of frequency?", Arrays.asList("Joule", "Hertz", "Pascal", "Newton"), 1, "Hard"));
        questions.add(new Question("Which organ is responsible for filtering blood in the human body?", Arrays.asList("Heart", "Lungs", "Kidneys", "Liver"), 2, "Hard"));
        questions.add(new Question("What is the chemical formula for Glucose?", Arrays.asList("C6H12O6", "CO2", "CH4", "C2H5OH"), 0, "Hard"));
        questions.add(new Question("What is the hardest known biological material?", Arrays.asList("Bone", "Wood", "Spider Silk", "Limpet Teeth"), 3, "Hard"));
        questions.add(new Question("Which element has the highest melting point?", Arrays.asList("Iron", "Tungsten", "Carbon", "Platinum"), 1, "Hard"));
        questions.add(new Question("What is the main source of energy for Earth's climate system?", Arrays.asList("Geothermal", "Lunar Gravitation", "Solar Radiation", "Ocean Currents"), 2, "Hard"));
        questions.add(new Question("Which planet has the shortest day in our solar system?", Arrays.asList("Mercury", "Venus", "Jupiter", "Saturn"), 2, "Hard"));
        questions.add(new Question("What is the charge of a neutron?", Arrays.asList("Positive", "Negative", "Neutral", "Variable"), 2, "Hard"));
        questions.add(new Question("Who is considered the father of genetics?", Arrays.asList("Darwin", "Mendel", "Watson", "Crick"), 1, "Hard"));

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
        questions.add(new Question("Who was the first woman to fly solo across the Atlantic?", Arrays.asList("Bessie Coleman", "Amelia Earhart", "Harriet Quimby", "Anne Morrow Lindbergh"), 1, "Medium"));
        questions.add(new Question("The Great Wall of China was primarily built to protect against which group?", Arrays.asList("The Romans", "The Mongols", "The Persians", "The Vikings"), 1, "Medium"));
        questions.add(new Question("Which empire was ruled by Julius Caesar?", Arrays.asList("Ottoman", "Roman", "Byzantine", "Holy Roman"), 1, "Medium"));
        questions.add(new Question("The Renaissance began in which country?", Arrays.asList("France", "Germany", "Italy", "Spain"), 2, "Medium"));
        questions.add(new Question("Who wrote the Declaration of Independence?", Arrays.asList("John Adams", "Thomas Jefferson", "Ben Franklin", "George Washington"), 1, "Medium"));
        questions.add(new Question("Which city was the first to be struck by an atomic bomb?", Arrays.asList("Nagasaki", "Tokyo", "Hiroshima", "Kyoto"), 2, "Medium"));
        questions.add(new Question("Who was the British Prime Minister during most of WW2?", Arrays.asList("Chamberlain", "Churchill", "Atlee", "Eden"), 1, "Medium"));
        questions.add(new Question("The Magna Carta was signed in which year?", Arrays.asList("1066", "1215", "1492", "1776"), 1, "Medium"));
        questions.add(new Question("Who was known as the 'Maid of Orleans'?", Arrays.asList("Marie Antoinette", "Catherine de Medici", "Joan of Arc", "Anne Boleyn"), 2, "Medium"));
        questions.add(new Question("The French Revolution began with the storming of which prison?", Arrays.asList("The Tower", "The Bastille", "Alcatraz", "Robben Island"), 1, "Medium"));
        questions.add(new Question("Who was the first human to travel into space?", Arrays.asList("Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "John Glenn"), 2, "Medium"));
        questions.add(new Question("The Titanic sank in which ocean?", Arrays.asList("Pacific", "Atlantic", "Indian", "Arctic"), 1, "Medium"));
        questions.add(new Question("Which ancient civilization built the Machu Picchu?", Arrays.asList("Maya", "Aztec", "Inca", "Olmec"), 2, "Medium"));
        questions.add(new Question("Who was the first man to step on the moon?", Arrays.asList("Buzz Aldrin", "Yuri Gagarin", "Neil Armstrong", "Michael Collins"), 2, "Medium"));
        questions.add(new Question("The Berlin Wall fell in which year?", Arrays.asList("1987", "1988", "1989", "1990"), 2, "Medium"));
        questions.add(new Question("Which pharaoh's tomb was discovered by Howard Carter in 1922?", Arrays.asList("Ramses II", "Tutankhamun", "Akhenaten", "Seti I"), 1, "Medium"));
        questions.add(new Question("The Industrial Revolution began in which country?", Arrays.asList("USA", "Germany", "Great Britain", "France"), 2, "Medium"));
        questions.add(new Question("Who was the leader of the Soviet Union during the Cuban Missile Crisis?", Arrays.asList("Stalin", "Khrushchev", "Brezhnev", "Gorbachev"), 1, "Medium"));
        questions.add(new Question("Which document ended the American Revolutionary War?", Arrays.asList("Treaty of Paris", "Treaty of Versailles", "The Constitution", "Treaty of Ghent"), 0, "Medium"));
        questions.add(new Question("Who was the first Emperor of Rome?", Arrays.asList("Julius Caesar", "Augustus", "Nero", "Caligula"), 1, "Medium"));
        questions.add(new Question("The ancient Olympic Games originated in which country?", Arrays.asList("Italy", "Egypt", "Greece", "China"), 2, "Medium"));
        questions.add(new Question("Which explorer led the first expedition to circumnavigate the globe?", Arrays.asList("Vasco da Gama", "Columbus", "Magellan", "Drake"), 2, "Medium"));
        questions.add(new Question("The apartheid system was enforced in which country?", Arrays.asList("Zimbabwe", "Kenya", "South Africa", "Nigeria"), 2, "Medium"));
        questions.add(new Question("Who was the queen of Ancient Egypt who had a relationship with Julius Caesar?", Arrays.asList("Nefertiti", "Cleopatra", "Hatshepsut", "Isis"), 1, "Medium"));
        questions.add(new Question("The Vietnam War ended in which year?", Arrays.asList("1973", "1974", "1975", "1976"), 2, "Medium"));
        questions.add(new Question("Which US President was responsible for the Emancipation Proclamation?", Arrays.asList("Andrew Jackson", "Ulysses S. Grant", "Abraham Lincoln", "Theodore Roosevelt"), 2, "Medium"));
        questions.add(new Question("The Black Death plague occurred during which century?", Arrays.asList("12th", "13th", "14th", "15th"), 2, "Medium"));
        questions.add(new Question("Who was the primary leader of the Indian Independence Movement?", Arrays.asList("Nehru", "Patel", "Mahatma Gandhi", "Bose"), 2, "Medium"));
        questions.add(new Question("Which treaty officially ended World War I?", Arrays.asList("Treaty of Paris", "Treaty of Versailles", "Treaty of London", "Treaty of Rome"), 1, "Medium"));
        questions.add(new Question("Who was the king of Macedon who created one of the largest empires of the ancient world?", Arrays.asList("Philip II", "Alexander the Great", "Pericles", "Leonidas"), 1, "Medium"));

        // --- HARD (30 Questions) ---
        questions.add(new Question("The 21st Dynasty of Egypt was primarily based in which city?", Arrays.asList("Thebes", "Memphis", "Tanis", "Alexandria"), 2, "Hard"));
        questions.add(new Question("In what year did the Byzantine Empire finally fall?", Arrays.asList("1453", "1492", "1204", "1517"), 0, "Hard"));
        questions.add(new Question("Who was the first female Prime Minister of a sovereign nation?", Arrays.asList("Margaret Thatcher", "Indira Gandhi", "Sirimavo Bandaranaike", "Golda Meir"), 2, "Hard"));
        questions.add(new Question("The Code of Hammurabi was the law code of which civilization?", Arrays.asList("Sumerian", "Assyrian", "Babylonian", "Persian"), 2, "Hard"));
        questions.add(new Question("Which naval battle in 1571 halted Ottoman expansion in the Mediterranean?", Arrays.asList("Battle of Actium", "Battle of Lepanto", "Battle of Trafalgar", "Battle of Navarino"), 1, "Hard"));
        questions.add(new Question("The 'Golden Bull' of 1356 was a decree issued by which empire?", Arrays.asList("Byzantine Empire", "Ottoman Empire", "Holy Roman Empire", "Russian Empire"), 2, "Hard"));
        questions.add(new Question("Who was the last Tsar of Russia?", Arrays.asList("Alexander III", "Nicholas II", "Peter the Great", "Ivan the Terrible"), 1, "Hard"));
        questions.add(new Question("The Opium Wars were fought between China and which other country?", Arrays.asList("France", "Russia", "Great Britain", "Japan"), 2, "Hard"));
        questions.add(new Question("Which peace treaty ended the Thirty Years' War in 1648?", Arrays.asList("Peace of Utrecht", "Peace of Westphalia", "Treaty of Pyrenees", "Edict of Nantes"), 1, "Hard"));
        questions.add(new Question("Who was the famous Carthaginian general who crossed the Alps with elephants?", Arrays.asList("Hamilcar Barca", "Hasdrubal", "Hannibal", "Scipio Africanus"), 2, "Hard"));
        questions.add(new Question("The Battle of Hastings in 1066 saw the victory of which leader?", Arrays.asList("Harold Godwinson", "William the Conqueror", "Richard the Lionheart", "Edward the Confessor"), 1, "Hard"));
        questions.add(new Question("Which ancient empire was led by Cyrus the Great?", Arrays.asList("Macedonian", "Egyptian", "Persian", "Roman"), 2, "Hard"));
        questions.add(new Question("The Meiji Restoration occurred in which country?", Arrays.asList("China", "Korea", "Japan", "Thailand"), 2, "Hard"));
        questions.add(new Question("Who was the Spanish conquistador who led the expedition that caused the fall of the Aztec Empire?", Arrays.asList("Francisco Pizarro", "Hernan Cortes", "Vasco de Balboa", "Juan Ponce de Leon"), 1, "Hard"));
        questions.add(new Question("The War of the Roses was a series of dynastic civil wars in which country?", Arrays.asList("France", "Scotland", "England", "Wales"), 2, "Hard"));
        questions.add(new Question("Which US President ordered the 'Trail of Tears'?", Arrays.asList("Andrew Jackson", "Martin Van Buren", "John Tyler", "James K. Polk"), 0, "Hard"));
        questions.add(new Question("The Edict of Milan in 313 AD established religious tolerance for which group?", Arrays.asList("Jews", "Christians", "Muslims", "Pagans"), 1, "Hard"));
        questions.add(new Question("Who was the first President of post-apartheid South Africa?", Arrays.asList("Desmond Tutu", "Nelson Mandela", "F.W. de Klerk", "Thabo Mbeki"), 1, "Hard"));
        questions.add(new Question("The Boxer Rebellion took place in which country?", Arrays.asList("Japan", "Korea", "China", "India"), 2, "Hard"));
        questions.add(new Question("Which philosopher was the tutor of Alexander the Great?", Arrays.asList("Socrates", "Plato", "Aristotle", "Epicurus"), 2, "Hard"));
        questions.add(new Question("The Han Dynasty is known as a golden age for which civilization?", Arrays.asList("Indian", "Chinese", "Japanese", "Vietnamese"), 1, "Hard"));
        questions.add(new Question("The Battle of Waterloo in 1815 marked the final defeat of which leader?", Arrays.asList("Louis XVI", "Napoleon Bonaparte", "Duke of Wellington", "Admiral Nelson"), 1, "Hard"));
        questions.add(new Question("Who was the Mongolian leader who founded the Mongol Empire?", Arrays.asList("Kublai Khan", "Genghis Khan", "Tamerlane", "Hulagu Khan"), 1, "Hard"));
        questions.add(new Question("The 'Iron Curtain' speech was given by which leader?", Arrays.asList("Roosevelt", "Truman", "Churchill", "Stalin"), 2, "Hard"));
        questions.add(new Question("Which conference in 1945 divided Germany into occupation zones?", Arrays.asList("Tehran Conference", "Yalta Conference", "Potsdam Conference", "Casablanca Conference"), 1, "Hard"));
        questions.add(new Question("The Reconquista was a series of campaigns to retake territory from the Moors in which region?", Arrays.asList("Italy", "Iberian Peninsula", "Balkans", "North Africa"), 1, "Hard"));
        questions.add(new Question("Who was the king of France known as the 'Sun King'?", Arrays.asList("Louis XIV", "Louis XV", "Louis XVI", "Napoleon"), 0, "Hard"));
        questions.add(new Question("The Great Leap Forward was a social and economic campaign in which country?", Arrays.asList("Soviet Union", "China", "North Korea", "Vietnam"), 1, "Hard"));
        questions.add(new Question("Which explorer discovered the sea route to India around the Cape of Good Hope?", Arrays.asList("Christopher Columbus", "Vasco da Gama", "Bartolomeu Dias", "Ferdinand Magellan"), 1, "Hard"));
        questions.add(new Question("The Peloponnesian War was fought between which two ancient Greek city-states?", Arrays.asList("Athens and Sparta", "Athens and Thebes", "Sparta and Corinth", "Thebes and Sparta"), 0, "Hard"));

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
        questions.add(new Question("In JavaScript, which keyword is used to declare a block-scoped variable?", Arrays.asList("var", "let", "const", "Both let and const"), 3, "Medium"));
        questions.add(new Question("What does the 'HTTP' acronym stand for?", Arrays.asList("HyperText Transfer Protocol", "HighText Transfer Process", "Hyperlink Transfer Protocol", "HyperText Tactical Protocol"), 0, "Medium"));
        questions.add(new Question("Which data structure uses the LIFO (Last In, First Out) principle?", Arrays.asList("Queue", "Stack", "Linked List", "Binary Tree"), 1, "Medium"));
        questions.add(new Question("What is the default port for an HTTP server?", Arrays.asList("21", "80", "443", "8080"), 1, "Medium"));
        questions.add(new Question("In Java, what is the parent class of all classes?", Arrays.asList("Main", "Base", "Object", "Root"), 2, "Medium"));
        questions.add(new Question("Which SQL clause is used to filter results?", Arrays.asList("WHERE", "FILTER", "SELECT", "ORDER BY"), 0, "Medium"));
        questions.add(new Question("What is the result of '2' + 2 in JavaScript?", Arrays.asList("4", "22", "undefined", "NaN"), 1, "Medium"));
        questions.add(new Question("Which of these is NOT a primitive data type in Java?", Arrays.asList("int", "double", "String", "boolean"), 2, "Medium"));
        questions.add(new Question("In Git, which command is used to download a repository from a remote source?", Arrays.asList("pull", "fetch", "clone", "fork"), 2, "Medium"));
        questions.add(new Question("What does CSS stand for?", Arrays.asList("Creative Style Sheets", "Cascading Style Sheets", "Computer Style Sheets", "Colorful Style Sheets"), 1, "Medium"));
        questions.add(new Question("In Python, how do you start a for loop?", Arrays.asList("for x in y:", "for(x; y; z)", "foreach(x in y)", "loop x in y"), 0, "Medium"));
        questions.add(new Question("What is the time complexity of searching in a Hash Map (average case)?", Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n log n)"), 0, "Medium"));
        questions.add(new Question("Which HTML tag is used for the largest heading?", Arrays.asList("<head>", "<h6>", "<h1>", "<header>"), 2, "Medium"));
        questions.add(new Question("In C++, which operator is used for the 'address-of'?", Arrays.asList("&", "*", "->", "."), 0, "Medium"));
        questions.add(new Question("What does JSON stand for?", Arrays.asList("Java Standard Object Notation", "JavaScript Object Notation", "Java Serialized Object Network", "JavaScript Online Notation"), 1, "Medium"));
        questions.add(new Question("Which command is used to list files in a directory in Linux?", Arrays.asList("dir", "ls", "list", "cd"), 1, "Medium"));
        questions.add(new Question("In SQL, what does 'CRUD' stand for?", Arrays.asList("Create, Read, Update, Delete", "Copy, Read, Union, Delete", "Create, Run, Update, Drop", "Compute, Read, Upload, Delete"), 0, "Medium"));
        questions.add(new Question("Which protocol is used for sending emails?", Arrays.asList("HTTP", "FTP", "SMTP", "SSH"), 2, "Medium"));
        questions.add(new Question("What is the binary representation of the decimal number 5?", Arrays.asList("100", "101", "110", "111"), 1, "Medium"));
        questions.add(new Question("In JavaScript, which function is used to parse a string into an integer?", Arrays.asList("Integer.parse()", "parseInt()", "toInt()", "number()"), 1, "Medium"));
        questions.add(new Question("Which CSS property is used to change the text color?", Arrays.asList("text-color", "font-color", "color", "background-color"), 2, "Medium"));
        questions.add(new Question("What is the primary purpose of a 'Docker' container?", Arrays.asList("Encryption", "Virtualization", "Application Packaging", "Database Storage"), 2, "Medium"));
        questions.add(new Question("In Java, which keyword is used to inherit a class?", Arrays.asList("implements", "extends", "inherits", "using"), 1, "Medium"));
        questions.add(new Question("Which symbol is used for comments in Python?", Arrays.asList("//", "/*", "#", "--"), 2, "Medium"));
        questions.add(new Question("What does DOM stand for in web development?", Arrays.asList("Data Object Model", "Document Object Model", "Digital Object Mode", "Document Online Management"), 1, "Medium"));
        questions.add(new Question("Which of these is a NoSQL database?", Arrays.asList("MySQL", "PostgreSQL", "MongoDB", "Oracle"), 2, "Medium"));
        questions.add(new Question("In Git, which command stages changes for a commit?", Arrays.asList("git add", "git stage", "git push", "git commit"), 0, "Medium"));
        questions.add(new Question("What is the purpose of the 'alt' attribute in an <img> tag?", Arrays.asList("Alignment", "Alternative Text", "Image Source", "Image Size"), 1, "Medium"));
        questions.add(new Question("Which programming language is known as the 'mother of all languages'?", Arrays.asList("Java", "Assembly", "C", "Fortran"), 2, "Medium"));
        questions.add(new Question("In JavaScript, what is 'NaN'?", Arrays.asList("Not a Name", "Not a Number", "New and Null", "Null and Negative"), 1, "Medium"));

        // --- HARD (30 Questions) ---
        questions.add(new Question("What is the time complexity of the QuickSort algorithm in the worst case?", Arrays.asList("O(n log n)", "O(n^2)", "O(n)", "O(log n)"), 1, "Hard"));
        questions.add(new Question("Which design pattern ensures a class has only one instance?", Arrays.asList("Factory", "Observer", "Singleton", "Strategy"), 2, "Hard"));
        questions.add(new Question("In Java, what is the difference between '==' and '.equals()' for Strings?", Arrays.asList("No difference", "== compares values, .equals() compares references", "== compares references, .equals() compares values", "== is for primitives only"), 2, "Hard"));
        questions.add(new Question("What is a 'deadlock' in operating systems?", Arrays.asList("A crashed computer", "A process that never finishes", "A situation where processes wait forever for each other's resources", "A security breach"), 2, "Hard"));
        questions.add(new Question("In C#, what is the purpose of the 'yield' keyword?", Arrays.asList("To stop a loop", "To return an element in an iterator", "To wait for a task", "To declare a constant"), 1, "Hard"));
        questions.add(new Question("Which protocol is used by Git for secure communication?", Arrays.asList("HTTP", "FTP", "SSH", "Telnet"), 2, "Hard"));
        questions.add(new Question("What is the maximum number of nodes in a binary tree of height h?", Arrays.asList("2h", "2^h", "2^(h+1) - 1", "h^2"), 2, "Hard"));
        questions.add(new Question("In networking, what does CIDR stand for?", Arrays.asList("Classless Inter-Domain Routing", "Core Internet Data Routing", "Combined Internal Data Range", "Classed Internet Domain Record"), 0, "Hard"));
        questions.add(new Question("Which sorting algorithm is stable and has O(n log n) time complexity?", Arrays.asList("QuickSort", "HeapSort", "MergeSort", "SelectionSort"), 2, "Hard"));
        questions.add(new Question("What is the 'Big O' complexity of adding an element to the beginning of a Linked List?", Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"), 0, "Hard"));
        questions.add(new Question("In Python, what is a 'decorator'?", Arrays.asList("A GUI element", "A function that modifies another function", "A class attribute", "A type of list"), 1, "Hard"));
        questions.add(new Question("What is the purpose of the 'volatile' keyword in Java?", Arrays.asList("To prevent serialization", "To ensure thread-safety of a variable", "To make a variable constant", "To speed up execution"), 1, "Hard"));
        questions.add(new Question("Which HTTP status code represents 'Internal Server Error'?", Arrays.asList("403", "404", "500", "503"), 2, "Hard"));
        questions.add(new Question("What is the primary difference between a 'Process' and a 'Thread'?", Arrays.asList("Threads share memory, processes don't", "Processes are faster", "Threads are independent applications", "There is no difference"), 0, "Hard"));
        questions.add(new Question("In SQL, what is the purpose of a 'JOIN'?", Arrays.asList("To combine rows from two or more tables", "To delete data", "To group results", "To create a new table"), 0, "Hard"));
        questions.add(new Question("What is the result of 0.1 + 0.2 === 0.3 in JavaScript?", Arrays.asList("true", "false", "undefined", "NaN"), 1, "Hard"));
        questions.add(new Question("Which encryption algorithm is commonly used for secure web browsing (HTTPS)?", Arrays.asList("DES", "AES", "RSA", "MD5"), 2, "Hard"));
        questions.add(new Question("In React, what is the purpose of 'useEffect'?", Arrays.asList("To style components", "To handle side effects", "To store state", "To navigate between pages"), 1, "Hard"));
        questions.add(new Question("What is 'Race Condition' in concurrent programming?", Arrays.asList("Fastest process wins", "An error in the UI", "A situation where output depends on sequence of events", "A network delay"), 2, "Hard"));
        questions.add(new Question("Which data structure is best for implementing a 'Undo' feature?", Arrays.asList("Queue", "Stack", "Tree", "Graph"), 1, "Hard"));
        questions.add(new Question("In C, what is the size of an 'int' on a 64-bit system (usually)?", Arrays.asList("2 bytes", "4 bytes", "8 bytes", "16 bytes"), 1, "Hard"));
        questions.add(new Question("What does the 'S' in 'SOLID' principles stand for?", Arrays.asList("Structural", "Single Responsibility", "Static", "Secure"), 1, "Hard"));
        questions.add(new Question("Which database isolation level prevents 'Dirty Reads'?", Arrays.asList("Read Uncommitted", "Read Committed", "Repeatable Read", "Serializable"), 1, "Hard"));
        questions.add(new Question("What is the time complexity of the Binary Search algorithm?", Arrays.asList("O(n)", "O(log n)", "O(n log n)", "O(1)"), 1, "Hard"));
        questions.add(new Question("In Linux, which signal is sent by the 'kill -9' command?", Arrays.asList("SIGTERM", "SIGINT", "SIGKILL", "SIGHUP"), 2, "Hard"));
        questions.add(new Question("What is the purpose of a 'Reverse Proxy'?", Arrays.asList("Caching", "Load Balancing", "Security", "All of these"), 3, "Hard"));
        questions.add(new Question("Which data structure is typically used to implement a BFS (Breadth-First Search)?", Arrays.asList("Stack", "Queue", "Priority Queue", "Deque"), 1, "Hard"));
        questions.add(new Question("In Java, what is the 'Diamond Problem'?", Arrays.asList("Memory Leak", "Multiple Inheritance ambiguity", "Infinite Recursion", "Garbage Collection issue"), 1, "Hard"));
        questions.add(new Question("What is the purpose of the 'finally' block in exception handling?", Arrays.asList("To catch exceptions", "To throw exceptions", "To execute code regardless of an exception", "To exit the program"), 2, "Hard"));
        questions.add(new Question("Which protocol operates at the Transport Layer of the OSI model?", Arrays.asList("IP", "TCP", "HTTP", "Ethernet"), 1, "Hard"));

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
        questions.add(new Question("Solve for x: 2x + 10 = 30", Arrays.asList("5", "10", "15", "20"), 1, "Medium"));
        questions.add(new Question("What is the area of a rectangle with length 8 and width 5?", Arrays.asList("13", "40", "26", "20"), 1, "Medium"));
        questions.add(new Question("What is 25% of 80?", Arrays.asList("15", "20", "25", "30"), 1, "Medium"));
        questions.add(new Question("What is the value of 3 squared plus 4 squared?", Arrays.asList("7", "12", "25", "49"), 2, "Medium"));
        questions.add(new Question("A triangle has angles 60 and 40. What is the third angle?", Arrays.asList("60", "80", "100", "120"), 1, "Medium"));
        questions.add(new Question("What is 100 divided by 4?", Arrays.asList("20", "25", "30", "50"), 1, "Medium"));
        questions.add(new Question("Simplify: 5(2 + 3) - 10", Arrays.asList("15", "25", "10", "5"), 0, "Medium"));
        questions.add(new Question("What is the next number in the sequence: 2, 4, 8, 16, ...?", Arrays.asList("24", "30", "32", "64"), 2, "Medium"));
        questions.add(new Question("How many degrees are in a right angle?", Arrays.asList("45", "90", "180", "360"), 1, "Medium"));
        questions.add(new Question("What is 7 multiplied by 8?", Arrays.asList("49", "54", "56", "63"), 2, "Medium"));
        questions.add(new Question("What is the perimeter of a square with side 6?", Arrays.asList("12", "24", "36", "48"), 1, "Medium"));
        questions.add(new Question("What is the cube of 3?", Arrays.asList("9", "27", "81", "12"), 1, "Medium"));
        questions.add(new Question("Solve for x: x/4 = 12", Arrays.asList("3", "8", "48", "36"), 2, "Medium"));
        questions.add(new Question("What is the sum of the first 5 prime numbers?", Arrays.asList("25", "26", "28", "30"), 2, "Medium"));
        questions.add(new Question("What is 10% of 500?", Arrays.asList("5", "50", "55", "100"), 1, "Medium"));
        questions.add(new Question("What is the square root of 169?", Arrays.asList("11", "12", "13", "14"), 2, "Medium"));
        questions.add(new Question("How many seconds are in 5 minutes?", Arrays.asList("150", "250", "300", "500"), 2, "Medium"));
        questions.add(new Question("What is the value of 2 to the power of 5?", Arrays.asList("10", "25", "32", "64"), 2, "Medium"));
        questions.add(new Question("What is the largest 2-digit prime number?", Arrays.asList("91", "93", "97", "99"), 2, "Medium"));
        questions.add(new Question("What is 1/2 + 1/4?", Arrays.asList("1/6", "2/6", "3/4", "1/8"), 2, "Medium"));
        questions.add(new Question("What is the average of 10, 20, and 30?", Arrays.asList("15", "20", "25", "30"), 1, "Medium"));
        questions.add(new Question("How many centimeters are in 2.5 meters?", Arrays.asList("25", "250", "2500", "0.25"), 1, "Medium"));
        questions.add(new Question("What is 99 - 18?", Arrays.asList("71", "81", "91", "117"), 1, "Medium"));
        questions.add(new Question("What is the value of pi (to 2 decimal places)?", Arrays.asList("3.12", "3.14", "3.16", "3.18"), 1, "Medium"));
        questions.add(new Question("How many faces does a cube have?", Arrays.asList("4", "6", "8", "12"), 1, "Medium"));
        questions.add(new Question("Solve: (10 + 5) * 2", Arrays.asList("20", "25", "30", "40"), 2, "Medium"));
        questions.add(new Question("What is 15 * 4?", Arrays.asList("45", "50", "60", "75"), 2, "Medium"));
        questions.add(new Question("What is the diameter of a circle with radius 10?", Arrays.asList("5", "10", "20", "31.4"), 2, "Medium"));
        questions.add(new Question("What is 1000 - 333?", Arrays.asList("666", "667", "767", "567"), 1, "Medium"));
        questions.add(new Question("What is the value of 0.5 as a fraction?", Arrays.asList("1/5", "1/2", "5/100", "1/4"), 1, "Medium"));

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
