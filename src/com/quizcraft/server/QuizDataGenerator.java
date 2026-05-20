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

    public static void main(String[] args) {
        generateInitialData();
    }

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
        questions.add(new Question("Which particle is proposed by the Standard Model to explain why some elementary particles have mass?", Arrays.asList("Higgs boson", "Graviton", "Photon", "Gluon"), 0, "Hard"));
        questions.add(new Question("What is the primary product of the CNO cycle in stellar nucleosynthesis?", Arrays.asList("Helium-4", "Carbon-12", "Nitrogen-14", "Oxygen-16"), 0, "Hard"));
        questions.add(new Question("Which law describes the relationship between the heat capacity of a solid and its vibrational modes at low temperatures?", Arrays.asList("Debye T^3 Law", "Dulong-Petit Law", "Einstein Solid Model", "Planck's Law"), 0, "Hard"));
        questions.add(new Question("What organic functional group is characterized by a carbon atom double-bonded to an oxygen atom and single-bonded to a hydroxyl group?", Arrays.asList("Carboxylic acid", "Ester", "Ketone", "Aldehyde"), 0, "Hard"));
        questions.add(new Question("In molecular biology, which enzyme is responsible for synthesizing short RNA sequences called primers during DNA replication?", Arrays.asList("Primase", "Helicase", "DNA Polymerase III", "Ligase"), 0, "Hard"));
        questions.add(new Question("What is the main astronomical reference point for measuring right ascension?", Arrays.asList("Vernal Equinox", "Celestial North Pole", "Greenwich Meridian", "Ecliptic Pole"), 0, "Hard"));
        questions.add(new Question("Which thermodynamic state function represents the maximum reversible work that can be performed by a system at constant temperature and pressure?", Arrays.asList("Gibbs Free Energy", "Helmholtz Free Energy", "Enthalpy", "Internal Energy"), 0, "Hard"));
        questions.add(new Question("What type of gene mutation results in a premature stop codon in the transcribed mRNA?", Arrays.asList("Nonsense mutation", "Missense mutation", "Silent mutation", "Frameshift mutation"), 0, "Hard"));
        questions.add(new Question("Which effect describes the shift in the spectral lines of an atom when subjected to an external electric field?", Arrays.asList("Stark effect", "Zeeman effect", "Raman effect", "Photoelectric effect"), 0, "Hard"));
        questions.add(new Question("What is the primary geological mineral that makes up the bulk of the Earth's lower mantle?", Arrays.asList("Bridgmanite", "Ringwoodite", "Olivine", "Post-perovskite"), 0, "Hard"));
        questions.add(new Question("Which class of organic compounds undergoes the Diels-Alder reaction?", Arrays.asList("Conjugated dienes and dienophiles", "Alcohols and carboxylic acids", "Ketones and primary amines", "Alkyl halides and nucleophiles"), 0, "Hard"));
        questions.add(new Question("What is the term for the minimum energy required to remove an electron from the surface of a metal in the photoelectric effect?", Arrays.asList("Work function", "Ionization potential", "Fermi energy", "Binding energy"), 0, "Hard"));
        questions.add(new Question("Which neurological pathway is primarily degenerated in patients with Parkinson's disease?", Arrays.asList("Nigrostriatal pathway", "Mesolimbic pathway", "Tuberoinfundibular pathway", "Mesocortical pathway"), 0, "Hard"));
        questions.add(new Question("What quantum number determines the orientation of an orbital in space?", Arrays.asList("Magnetic quantum number (m_l)", "Azimuthal quantum number (l)", "Principal quantum number (n)", "Spin quantum number (m_s)"), 0, "Hard"));
        questions.add(new Question("Which cosmological epoch refers to the period when the universe cooled enough for electrons to bind to protons, forming neutral hydrogen?", Arrays.asList("Recombination", "Nucleosynthesis", "Inflation", "Reionization"), 0, "Hard"));
        questions.add(new Question("What is the correct IUPAC name for the simplest chiral alkane?", Arrays.asList("3-methylhexane", "2-methylbutane", "3-methylpentane", "2,3-dimethylbutane"), 0, "Hard"));
        questions.add(new Question("In immunology, which class of antibody is secreted in pentameric form and is the first to respond during an primary infection?", Arrays.asList("IgM", "IgG", "IgA", "IgE"), 0, "Hard"));
        questions.add(new Question("Which physical principle explains why a spinning top precesses instead of falling over?", Arrays.asList("Conservation of Angular Momentum", "Conservation of Linear Momentum", "Coriolis Force", "Centripetal Acceleration"), 0, "Hard"));
        questions.add(new Question("Which complex in the mitochondrial electron transport chain is also part of the citric acid cycle (Krebs cycle)?", Arrays.asList("Complex II (Succinate dehydrogenase)", "Complex I (NADH dehydrogenase)", "Complex III (Cytochrome bc1)", "Complex IV (Cytochrome c oxidase)"), 0, "Hard"));
        questions.add(new Question("What is the primary coordinate system used by astronomers to specify the positions of stars relative to the Earth's equator?", Arrays.asList("Equatorial coordinate system", "Ecliptic coordinate system", "Galactic coordinate system", "Horizontal coordinate system"), 0, "Hard"));
        questions.add(new Question("Which mechanism explains the superconductivity of materials at extremely low temperatures via electron pairing?", Arrays.asList("BCS Theory", "Ginzburg-Landau Theory", "Hubbard Model", "London Equations"), 0, "Hard"));
        questions.add(new Question("What type of intermolecular force is primarily responsible for the unique high boiling point of water?", Arrays.asList("Hydrogen bonding", "London dispersion forces", "Dipole-dipole interactions", "Ion-dipole forces"), 0, "Hard"));
        questions.add(new Question("In biochemistry, what is the term for an inactive enzyme precursor that requires proteolytic cleavage to become active?", Arrays.asList("Zymogen", "Apoenzyme", "Coenzyme", "Holozyme"), 0, "Hard"));
        questions.add(new Question("Which constant represents the quantization of electromagnetic radiation, relating a photon's energy to its frequency?", Arrays.asList("Planck's constant (h)", "Boltzmann's constant (k_B)", "Rydberg constant (R_inf)", "Fine-structure constant (alpha)"), 0, "Hard"));
        questions.add(new Question("What is the name of the hypothetical boundary surrounding a black hole beyond which nothing can escape?", Arrays.asList("Event Horizon", "Ergosphere", "Schwarzschild Radius", "Photon Sphere"), 0, "Hard"));
        questions.add(new Question("Which organic reaction converts a primary amide into a primary amine with one fewer carbon atom?", Arrays.asList("Hofmann rearrangement", "Curtius rearrangement", "Beckmann rearrangement", "Claisen condensation"), 0, "Hard"));
        questions.add(new Question("What is the major structural protein found in animal connective tissues, characterized by a triple-helix structure?", Arrays.asList("Collagen", "Keratin", "Elastin", "Fibroin"), 0, "Hard"));
        questions.add(new Question("Which mechanical quantity is defined as the rotational analog of mass, measuring an object's resistance to angular acceleration?", Arrays.asList("Moment of Inertia", "Torque", "Angular Momentum", "Rotational Kinetic Energy"), 0, "Hard"));
        questions.add(new Question("Which region of the human brain is the primary site for the consolidation of short-term memory into long-term memory?", Arrays.asList("Hippocampus", "Amygdala", "Cerebellum", "Prefrontal Cortex"), 0, "Hard"));
        questions.add(new Question("What is the term for the phase transition where a substance passes directly from the solid to the gaseous state without passing through the liquid state?", Arrays.asList("Sublimation", "Deposition", "Vaporization", "Condensation"), 0, "Hard"));

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
        questions.add(new Question("Which obscure treaty signed in 1494 divided the newly discovered lands outside Europe between Portugal and Castile?", Arrays.asList("Treaty of Tordesillas", "Treaty of Zaragoza", "Treaty of Alcáçovas", "Treaty of Westphalia"), 0, "Hard"));
        questions.add(new Question("Who was the Byzantine emperor who survived the Nika Riots in 532 AD and commissioned the rebuilding of the Hagia Sophia?", Arrays.asList("Justinian I", "Constantine the Great", "Heraclius", "Basil II"), 0, "Hard"));
        questions.add(new Question("Which Chinese dynasty was founded by Zhu Yuanzhang (the Hongwu Emperor) after the overthrow of the Mongol-led Yuan Dynasty?", Arrays.asList("Ming Dynasty", "Qing Dynasty", "Song Dynasty", "Tang Dynasty"), 0, "Hard"));
        questions.add(new Question("The Battle of Lepanto in 1571 was fought between the Ottoman Empire and which coalition of Christian maritime states?", Arrays.asList("The Holy League", "The Hanseatic League", "The Protestant Union", "The Catholic League"), 0, "Hard"));
        questions.add(new Question("Which 18th-century conflict is widely considered the first global war, fought across Europe, the Americas, and India?", Arrays.asList("The Seven Years' War", "The Thirty Years' War", "The War of the Spanish Succession", "The Napoleonic Wars"), 0, "Hard"));
        questions.add(new Question("Who was the last ruling monarch of the Kingdom of Hawaii before the monarchy was overthrown in 1893?", Arrays.asList("Queen Liliuokalani", "King Kamehameha V", "Queen Kaahumanu", "King Kalakaua"), 0, "Hard"));
        questions.add(new Question("Which peace treaty in 1648 recognized the independence of the Dutch Republic and the Swiss Confederation?", Arrays.asList("Peace of Westphalia", "Treaty of Utrecht", "Peace of Augsburg", "Treaty of Pyrenees"), 0, "Hard"));
        questions.add(new Question("Which Roman general defeated Hannibal Barca at the Battle of Zama in 202 BC?", Arrays.asList("Scipio Africanus", "Julius Caesar", "Mark Antony", "Pompey the Great"), 0, "Hard"));
        questions.add(new Question("The Meiji Restoration of 1868 returned practical imperial rule to Japan under Emperor Meiji, ending which military government?", Arrays.asList("Tokugawa Shogunate", "Kamakura Shogunate", "Ashikaga Shogunate", "Minamoto Clan"), 0, "Hard"));
        questions.add(new Question("Who was the Spanish conquistador who led the conquest of the Inca Empire in Peru?", Arrays.asList("Francisco Pizarro", "Hernán Cortés", "Francisco de Orellana", "Diego de Almagro"), 0, "Hard"));
        questions.add(new Question("Which dynastic conflict in England (1455-1487) was fought between the rival houses of Lancaster and York?", Arrays.asList("The Wars of the Roses", "The Hundred Years' War", "The English Civil War", "The Bishops' Wars"), 0, "Hard"));
        questions.add(new Question("Which U.S. President signed the Indian Removal Act of 1830, leading to the forced displacement known as the 'Trail of Tears'?", Arrays.asList("Andrew Jackson", "Martin Van Buren", "John Quincy Adams", "James K. Polk"), 0, "Hard"));
        questions.add(new Question("The Edict of Nantes (1598), which granted substantial rights to Calvinist Protestants (Huguenots) in France, was issued by which king?", Arrays.asList("Henry IV", "Louis XIV", "Francis I", "Louis XIII"), 0, "Hard"));
        questions.add(new Question("Who was the prominent leader of the Haitian Revolution, a former slave who became a general and governor-general?", Arrays.asList("Toussaint Louverture", "Jean-Jacques Dessalines", "Henri Christophe", "Dutty Boukman"), 0, "Hard"));
        questions.add(new Question("Which uprising in China (1899-1901) was an anti-foreign, anti-colonial, and anti-Christian movement supported by the Qing court?", Arrays.asList("The Boxer Rebellion", "The Taiping Rebellion", "The White Lotus Rebellion", "The Xinhai Revolution"), 0, "Hard"));
        questions.add(new Question("Which ancient Greek philosopher and scientist was appointed as the tutor of a young Alexander the Great?", Arrays.asList("Aristotle", "Plato", "Socrates", "Diogenes"), 0, "Hard"));
        questions.add(new Question("The Han Dynasty of China is widely considered a golden age, but it was briefly interrupted by which usurper's Xin Dynasty?", Arrays.asList("Wang Mang", "Cao Cao", "Liu Bang", "Sima Yi"), 0, "Hard"));
        questions.add(new Question("At which battle in 1815 was the French Emperor Napoleon Bonaparte finally defeated by allied British and Prussian forces?", Arrays.asList("Battle of Waterloo", "Battle of Leipzig", "Battle of Austerlitz", "Battle of Trafalgar"), 0, "Hard"));
        questions.add(new Question("Which Mongol leader successfully united the nomadic tribes of Northeast Asia and founded the Mongol Empire in 1206?", Arrays.asList("Genghis Khan", "Kublai Khan", "Ogedei Khan", "Hulagu Khan"), 0, "Hard"));
        questions.add(new Question("Which famous speech delivered by Winston Churchill in Fulton, Missouri, in 1946 popularized the term 'Iron Curtain'?", Arrays.asList("Sinews of Peace", "We Shall Fight on the Beaches", "Their Finest Hour", "Blood, Toil, Tears, and Sweat"), 0, "Hard"));
        questions.add(new Question("Which crucial conference in February 1945 saw Churchill, Roosevelt, and Stalin discuss the post-war reorganization of Germany and Europe?", Arrays.asList("Yalta Conference", "Potsdam Conference", "Tehran Conference", "Casablanca Conference"), 0, "Hard"));
        questions.add(new Question("The 'Reconquista' was a centuries-long campaign to retake the Iberian Peninsula from Islamic rule, ending with the fall of which last emirate in 1492?", Arrays.asList("Emirate of Granada", "Caliphate of Córdoba", "Taifa of Seville", "Kingdom of Toledo"), 0, "Hard"));
        questions.add(new Question("Which absolute monarch of France, known as the 'Sun King' (le Roi Soleil), built the Palace of Versailles and reigned for 72 years?", Arrays.asList("Louis XIV", "Louis XV", "Louis XVI", "Louis XIII"), 0, "Hard"));
        questions.add(new Question("What was the name of the socio-economic campaign launched by Mao Zedong in China (1958-1962) that aimed to rapidly transform the country from an agrarian economy into a socialist society?", Arrays.asList("The Great Leap Forward", "The Cultural Revolution", "The Hundred Flowers Campaign", "The Socialist Education Movement"), 0, "Hard"));
        questions.add(new Question("Which explorer commanded the first expedition that successfully sailed from Europe to India around the Cape of Good Hope?", Arrays.asList("Vasco da Gama", "Bartolomeu Dias", "Ferdinand Magellan", "Christopher Columbus"), 0, "Hard"));
        questions.add(new Question("The Peloponnesian War (431-404 BC) was a devastating ancient Greek conflict fought primarily between which two prominent alliances led by rival city-states?", Arrays.asList("Athens and Sparta", "Athens and Thebes", "Sparta and Corinth", "Thebes and Sparta"), 0, "Hard"));
        questions.add(new Question("Which Persian emperor founded the Achaemenid Empire and issued the famous Cyrus Cylinder, often called the first declaration of human rights?", Arrays.asList("Cyrus the Great", "Darius the Great", "Xerxes I", "Cambyses II"), 0, "Hard"));
        questions.add(new Question("Which prime minister of the United Kingdom, serving during the mid-19th century, is known for repealing the Corn Laws and founding the modern Conservative Party?", Arrays.asList("Robert Peel", "Benjamin Disraeli", "William Gladstone", "Lord Palmerston"), 0, "Hard"));
        questions.add(new Question("The ancient city of Carthage, a powerful rival of the Roman Republic in the Punic Wars, was located in what modern-day country?", Arrays.asList("Tunisia", "Algeria", "Morocco", "Libya"), 0, "Hard"));
        questions.add(new Question("What was the name of the secret treaty signed in 1916 between the UK and France, with Russian assent, that defined their proposed spheres of influence in the Middle East after WW1?", Arrays.asList("Sykes-Picot Agreement", "Balfour Declaration", "Treaty of Sèvres", "McMahon-Hussein Correspondence"), 0, "Hard"));

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
        questions.add(new Question("What is the worst-case time complexity of the QuickSort algorithm?", Arrays.asList("O(n^2)", "O(n log n)", "O(n)", "O(log n)"), 0, "Hard"));
        questions.add(new Question("Which Gang of Four (GoF) design pattern is used to decouple an abstraction from its implementation so that the two can vary independently?", Arrays.asList("Bridge", "Adapter", "Decorator", "Facade"), 0, "Hard"));
        questions.add(new Question("In Java, what is the key difference between '==' and the '.equals()' method when comparing two String objects?", Arrays.asList("'==' compares references, '.equals()' compares value contents", "'==' compares value contents, '.equals()' compares references", "There is no difference", "'==' is only valid for primitive numeric types"), 0, "Hard"));
        questions.add(new Question("What is the term for a concurrency issue where two or more processes are unable to proceed because each is waiting for the other to release a resource?", Arrays.asList("Deadlock", "Livelock", "Race Condition", "Starvation"), 0, "Hard"));
        questions.add(new Question("In C#, what does the 'yield return' statement do inside an iterator method?", Arrays.asList("It returns one element at a time, pausing execution until the next iteration", "It stops the loop and returns the entire collection immediately", "It spawns a new thread to run the loop in the background", "It throws an exception if the collection is empty"), 0, "Hard"));
        questions.add(new Question("Which protocol is typically used by Git for secure, passwordless authentication and data transfer?", Arrays.asList("SSH", "HTTPS", "FTP", "Telnet"), 0, "Hard"));
        questions.add(new Question("What is the maximum number of nodes in a binary tree of height 'h' (where height of a single root node is 0)?", Arrays.asList("2^(h+1) - 1", "2^h", "2h - 1", "h^2"), 0, "Hard"));
        questions.add(new Question("In networking, what does the 'CIDR' notation represent?", Arrays.asList("Classless Inter-Domain Routing", "Core Internet Data Router", "Combined Internal Domain Registration", "Classed IP Distribution Range"), 0, "Hard"));
        questions.add(new Question("Which sorting algorithm is stable and guarantees a time complexity of O(n log n) in all cases (best, worst, average)?", Arrays.asList("MergeSort", "QuickSort", "HeapSort", "SelectionSort"), 0, "Hard"));
        questions.add(new Question("What is the time complexity of prepending (inserting at the beginning) an element into a singly linked list with 'n' elements?", Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"), 0, "Hard"));
        questions.add(new Question("In Python, what is a decorator?", Arrays.asList("A function that takes another function as an argument and extends its behavior without modifying it", "A class attribute used to design user interfaces", "A mechanism to declare constant variables", "A built-in GUI library in the standard library"), 0, "Hard"));
        questions.add(new Question("In Java, what is the primary purpose of the 'volatile' keyword when applied to a class field?", Arrays.asList("To guarantee that reads/writes to the variable are synchronized across all threads", "To prevent the variable from being serialized during network transmission", "To make the variable read-only and constant", "To speed up calculation performance on multi-core CPUs"), 0, "Hard"));
        questions.add(new Question("Which HTTP status code is returned by a server when it encounters an unexpected condition that prevents it from fulfilling the request?", Arrays.asList("500 Internal Server Error", "403 Forbidden", "404 Not Found", "503 Service Unavailable"), 0, "Hard"));
        questions.add(new Question("What is the primary architectural difference between a Process and a Thread in operating systems?", Arrays.asList("Threads share the memory space of their parent process, whereas processes have independent memory spaces", "Processes are lightweight compared to threads", "Threads cannot be run concurrently on multi-core systems", "Processes do not have overhead"), 0, "Hard"));
        questions.add(new Question("In relational databases, which SQL operator is used to combine rows from two or more tables based on a related column?", Arrays.asList("JOIN", "UNION", "MERGE", "GROUP BY"), 0, "Hard"));
        questions.add(new Question("In JavaScript, what is the result of evaluating '0.1 + 0.2 === 0.3' due to floating-point representation?", Arrays.asList("false", "true", "undefined", "NaN"), 0, "Hard"));
        questions.add(new Question("Which asymmetric encryption algorithm relies on the mathematical difficulty of factoring large prime numbers for its security?", Arrays.asList("RSA", "AES", "DES", "Blowfish"), 0, "Hard"));
        questions.add(new Question("In React, what is the primary purpose of the 'useEffect' hook?", Arrays.asList("To perform side effects in functional components", "To manage local state variables", "To speed up rendering speeds", "To navigate between application pages"), 0, "Hard"));
        questions.add(new Question("What is a 'Race Condition' in concurrent programming?", Arrays.asList("A bug where the output of a program depends on the non-deterministic execution order of concurrent threads", "An application crash when a thread takes too long to respond", "A competition between processes to see which completes first", "A network bottleneck due to high packet speeds"), 0, "Hard"));
        questions.add(new Question("Which data structure is most appropriate and efficient for implementing a multi-level 'Undo' history in an application?", Arrays.asList("Stack", "Queue", "Binary Search Tree", "Hash Map"), 0, "Hard"));
        questions.add(new Question("On a standard 64-bit operating system, what is the typical memory size of an 'int' data type in C?", Arrays.asList("4 bytes", "2 bytes", "8 bytes", "16 bytes"), 0, "Hard"));
        questions.add(new Question("What does the 'S' stand for in the 'SOLID' object-oriented design principles?", Arrays.asList("Single Responsibility Principle", "Structural Design Principle", "State Management Principle", "Static Class Principle"), 0, "Hard"));
        questions.add(new Question("In database systems, which transaction isolation level is the highest and completely prevents 'Dirty Reads', 'Non-Repeatable Reads', and 'Phantom Reads'?", Arrays.asList("Serializable", "Read Committed", "Repeatable Read", "Read Uncommitted"), 0, "Hard"));
        questions.add(new Question("What is the worst-case time complexity of searching for a value in a balanced Binary Search Tree (like an AVL tree) with 'n' nodes?", Arrays.asList("O(log n)", "O(n)", "O(n log n)", "O(1)"), 0, "Hard"));
        questions.add(new Question("In Linux/UNIX administration, what signal is sent to a process when executing the 'kill -9' command?", Arrays.asList("SIGKILL", "SIGTERM", "SIGINT", "SIGHUP"), 0, "Hard"));
        questions.add(new Question("What is the primary benefit of deploying a 'Reverse Proxy' server like Nginx in front of a web application?", Arrays.asList("All of these (Load balancing, SSL termination, and security caching)", "SSL decryption termination", "Intelligent load balancing across backend nodes", "Static content caching and security filtering"), 0, "Hard"));
        questions.add(new Question("Which data structure is typically used to implement a Breadth-First Search (BFS) algorithm on a graph?", Arrays.asList("Queue", "Stack", "Priority Queue", "Linked List"), 0, "Hard"));
        questions.add(new Question("In object-oriented programming, what is the 'Diamond Problem'?", Arrays.asList("An ambiguity that arises when a class inherits from two classes that both inherit from a single superclass", "A memory leak caused by circular object references", "An infinite recursion bug when calling overloaded constructors", "A performance bottleneck in deep hierarchy trees"), 0, "Hard"));
        questions.add(new Question("What is the purpose of the 'finally' block in a try-catch-finally exception handling structure?", Arrays.asList("To execute cleanup code regardless of whether an exception was thrown or caught", "To catch any remaining unhandled exceptions", "To throw a new exception to the calling method", "To terminate the application immediately"), 0, "Hard"));
        questions.add(new Question("Which layer of the OSI network model is responsible for logical addressing, routing, and packet forwarding?", Arrays.asList("Network Layer", "Transport Layer", "Data Link Layer", "Physical Layer"), 0, "Hard"));

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
        questions.add(new Question("What is the derivative of x^x with respect to x?", Arrays.asList("x^x (ln(x) + 1)", "x * x^(x-1)", "x^x", "x^x * ln(x)"), 0, "Hard"));
        questions.add(new Question("Which English mathematician famously proved Fermat's Last Theorem in 1994?", Arrays.asList("Andrew Wiles", "Alan Turing", "G. H. Hardy", "Roger Penrose"), 0, "Hard"));
        questions.add(new Question("What is the value of the infinite series 1/1^2 + 1/2^2 + 1/3^2 + ... (known as the Basel Problem)?", Arrays.asList("pi^2 / 6", "pi / 4", "ln(2)", "pi^2 / 8"), 0, "Hard"));
        questions.add(new Question("What is the value of the Gaussian integral (the integral from negative infinity to infinity of e^(-x^2) dx)?", Arrays.asList("sqrt(pi)", "sqrt(pi) / 2", "1", "2 * sqrt(pi)"), 0, "Hard"));
        questions.add(new Question("What is the mathematical term for a non-orientable 2D surface that has only one side and one boundary?", Arrays.asList("Mobius strip", "Klein bottle", "Torus", "Projective plane"), 0, "Hard"));
        questions.add(new Question("How many regular convex polyhedra (Platonic solids) exist in 3-dimensional space?", Arrays.asList("5", "4", "6", "8"), 0, "Hard"));
        questions.add(new Question("The Riemann Hypothesis, one of the Millennium Prize Problems, states that all non-trivial zeros of the Riemann zeta function have a real part equal to what?", Arrays.asList("1/2", "1", "0", "-1/2"), 0, "Hard"));
        questions.add(new Question("What is the value of i^i (where 'i' is the imaginary unit, sqrt(-1))?", Arrays.asList("e^(-pi/2)", "e^(pi/2)", "i", "-1"), 0, "Hard"));
        questions.add(new Question("In axiomatic set theory, which hypothesis asserts that there is no set whose cardinality is strictly between that of the integers and the real numbers?", Arrays.asList("Continuum Hypothesis", "Axiom of Choice", "Well-Ordering Theorem", "Russell's Paradox"), 0, "Hard"));
        questions.add(new Question("How many vertices does a regular dodecahedron possess?", Arrays.asList("20", "12", "30", "8"), 0, "Hard"));
        questions.add(new Question("Which mathematical constant represents the limiting ratio of the bifurcation intervals in chaos theory?", Arrays.asList("Feigenbaum constant (delta)", "Euler-Mascheroni constant (gamma)", "Golden ratio (phi)", "Apéry's constant"), 0, "Hard"));
        questions.add(new Question("What is the order (number of elements) of the smallest non-abelian simple group?", Arrays.asList("60", "168", "360", "504"), 0, "Hard"));
        questions.add(new Question("What is the exact algebraic value of the Golden Ratio (phi)?", Arrays.asList("(1 + sqrt(5)) / 2", "(1 - sqrt(5)) / 2", "1.618", "sqrt(2) + 1"), 0, "Hard"));
        questions.add(new Question("Under which integral transform is a convolution of two functions represented as a simple multiplication of their individual transforms?", Arrays.asList("All of these (Fourier, Laplace, and Z-Transforms)", "Fourier Transform", "Laplace Transform", "Z-Transform"), 0, "Hard"));
        questions.add(new Question("Which fundamental mathematical theorem states that every bounded sequence in R^n has a convergent subsequence?", Arrays.asList("Bolzano-Weierstrass Theorem", "Heine-Borel Theorem", "Mean Value Theorem", "Taylor's Theorem"), 0, "Hard"));
        questions.add(new Question("In graph theory, what is the maximum number of edges in a simple bipartite graph with 'n' vertices?", Arrays.asList("n^2 / 4", "n(n-1) / 2", "n^2 / 2", "n"), 0, "Hard"));
        questions.add(new Question("What is the Gaussian curvature of a flat, two-dimensional Euclidean plane?", Arrays.asList("0", "1", "-1", "Variable"), 0, "Hard"));
        questions.add(new Question("Which famous mathematical paradox describes a hotel with infinitely many rooms that can still accommodate new guests?", Arrays.asList("Hilbert's Paradox of the Grand Hotel", "Banach-Tarski Paradox", "Russell's Paradox", "Zeno's Paradox"), 0, "Hard"));
        questions.add(new Question("The natural exponential base 'e' is mathematically defined as the limit of '(1 + 1/n)^n' as 'n' approaches what?", Arrays.asList("Infinity", "1", "0", "e"), 0, "Hard"));
        questions.add(new Question("In statistics, what approximate percentage of data values falls within two standard deviations of the mean in a normal (Gaussian) distribution?", Arrays.asList("~95.4%", "~68.3%", "~99.7%", "~50.0%"), 0, "Hard"));
        questions.add(new Question("What is the transcendental number that represents the ratio of a circle's circumference to its diameter?", Arrays.asList("pi", "e", "phi", "Euler's constant"), 0, "Hard"));
        questions.add(new Question("Which topological space is formed by taking a square and gluing the opposite edges together, with one pair reversed?", Arrays.asList("Klein bottle", "Mobius strip", "Torus", "Sphere"), 0, "Hard"));
        questions.add(new Question("In cryptography, the security of the Diffie-Hellman key exchange is primarily based on the computational difficulty of solving which mathematical problem?", Arrays.asList("Discrete Logarithm Problem", "Integer Factorization Problem", "Elliptic Curve Addition", "Knapsack Problem"), 0, "Hard"));
        questions.add(new Question("How many dimensions are required to construct a tesseract (a 4-dimensional hypercube)?", Arrays.asList("4", "3", "5", "8"), 0, "Hard"));
        questions.add(new Question("What is the term for a real number that cannot be expressed as a fraction of two integers, such as the square root of 2?", Arrays.asList("Irrational number", "Rational number", "Complex number", "Integer"), 0, "Hard"));
        questions.add(new Question("Which theorem states that every non-constant polynomial of degree 'n' with complex coefficients has exactly 'n' complex roots, counted with multiplicity?", Arrays.asList("Fundamental Theorem of Algebra", "Fundamental Theorem of Calculus", "Fundamental Theorem of Arithmetic", "Abel-Ruffini Theorem"), 0, "Hard"));
        questions.add(new Question("In abstract algebra, if every element in a group is its own inverse (g * g = e for all g), then what property must the group satisfy?", Arrays.asList("It must be Abelian", "It must be Cyclic", "It must be Infinite", "It must be Non-abelian"), 0, "Hard"));
        questions.add(new Question("Which prolific Swiss mathematician introduced the function notation 'f(x)', the base of natural log 'e', and the summation symbol 'Sigma'?", Arrays.asList("Leonhard Euler", "Isaac Newton", "Gottfried Leibniz", "René Descartes"), 0, "Hard"));
        questions.add(new Question("What is the exact sum of the infinite geometric series 1/2 + 1/4 + 1/8 + 1/16 + ...?", Arrays.asList("1", "2", "1.5", "Infinity"), 0, "Hard"));
        questions.add(new Question("What is the exact mathematical value of the gamma function evaluated at 1/2, Gamma(1/2)?", Arrays.asList("sqrt(pi)", "1", "sqrt(2)", "pi"), 0, "Hard"));

        return new Quiz("maths-quiz-java", "Mathematics", "Maths", "Arithmetic, Algebra, and Calculus.", questions);
    }
}
