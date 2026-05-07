# ⛏️ QuizCraft

A Minecraft-themed interactive quiz application built with pure Java.

## Features
- **Minecraft Aesthetics**: Pixelated UI, VT323 font, and grass/dirt themes.
- **Health Bar System**: 10 hearts that deplete on wrong answers.
- **Game Over Mechanics**: "YOU DIED!" screen when hearts reach zero.
- **Pure Java Server**: No Spring Boot or Maven required.

## Project Structure
- `src/`: Java source code.
- `resources/static/`: Frontend files (HTML, CSS, JS, Images).
- `resources/data/`: Quiz data in JSON format.

## How to Run in VS Code
1. Open the `quizcraft` folder in VS Code.
2. Ensure you have the **Extension Pack for Java** installed.
3. Press `F5` or go to the **Run and Debug** tab and click **QuizCraft**.
4. The server will start and your browser will open automatically to `http://localhost:8080`.

## How to Run from Terminal
1. Open a terminal in the `quizcraft` directory.
2. Compile: `javac -d bin -sourcepath src src/com/quizcraft/Main.java`
3. Run: `java -cp bin com.quizcraft.Main`
4. The server will start and your browser will open automatically.
