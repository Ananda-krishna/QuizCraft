# ⛏️ QuizCraft

A Minecraft-themed interactive quiz application built with pure Java.

## Features
- **Themed Login System**: Manual Gmail & Password login with auto-generated pixel-art avatars.
- **Difficulty Levels**: Easy, Normal, and Hardcore modes with over 400+ questions.
- **Minecraft Aesthetics**: Pixelated UI, VT323 font, and grass/dirt themes.
- **Health Bar System**: 10 hearts that deplete on wrong answers with screen-shake effects.
- **Game Over Mechanics**: "YOU DIED!" screen when hearts reach zero.
- **Pure Java Server**: A lightweight, dependency-free Java backend.

## Project Structure
- `src/`: Java source code.
- `resources/static/`: Frontend files (HTML, CSS, JS, Images).
- `resources/data/`: Quiz data in JSON format.

## How to Run in VS Code
1. Open the `quizcraft` folder in VS Code.
2. Ensure you have the **Extension Pack for Java** installed.
3. Press `F5` or go to the **Run and Debug** tab and click **QuizCraft**.
4. The server will start and your browser will open automatically to `http://localhost:8080`.

## How to Login
- **Email**: Any `@gmail.com` address.
- **Password**: `minecraft`

## How to Run from Terminal
1. Open a terminal in the `quizcraft` directory.
2. Compile: `javac -d bin -sourcepath src src/com/quizcraft/Main.java`
3. Run: `java -cp bin com.quizcraft.Main`
4. The server will start and your browser will open automatically.
