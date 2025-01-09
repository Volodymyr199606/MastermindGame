# MastermindGame

- [Game Rules](#game-rules)
- [Thought Proces](#thought-process)
- [Implementing the game](#implementing-the-game)
- [Example Run](#example-run)
- [Instructions How To Build And Start The Game](#instructions-how-to-build-and-start-the-game)
- [Database Setup](#database-setup)
- [Database Schema (SQLite)](#database-schema-sqlite)
- [Dependencies](#dependencies)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Extensions](#extensions)
- [Challenges](#challenges)
- [TO DO](#to-do)

## Game Rules
At the start of the game, the computer randomly selects a pattern of four different numbers from a total of 8 different numbers (0-7).
The player has 10 attempts to guess the number combinations
After each guess, the computer provides feedback

   - The player guessed a correct number.
   - The player guessed a correct number and its correct location.
   - The player's guess was incorrect.
  

## Thought Process
- 1 The initial goal was to create a robust, easy-to-understand, functional, and maintainable Mastermind game using
Object-Oriented programming. I wanted the game to be solid, easy to extend, and straightforward to modify in the future.
This would ensure that it could evolve over time without needing a complete redesign.


- 2 One of the key considerations during the development process was ensuring the quality and reliability of the game.
To achieve this, I focused on making the game easily testable, which would enable me to catch issues early and prevent
future bugs when adding new features or making changes. By implementing thorough testing practices early in the development cycle,
I ensured the game would be reliable, and that future changes or features could be integrated smoothly without introducing bugs or breaking existing functionality.

- 3 After establishing the core gameplay, I later extended the game by adding features like a Timer, Hint Provider, and
   Difficulty Level to enhance the overall gameplay experience. These extensions were designed to provide more engaging and dynamic challenges to the player.

## Implementing the game
`Gameplay Classes`
- Game: Manages the game loop, user interactions, and coordinates with GameLogic and PrintHelper.
- GameLogic: Handles secret code generation, guess evaluation, and feedback.
- Playable: Interface ensuring consistency across different game modes.

`Utility and Helper Classes`
- PrintHelper: Centralizes user-facing output (instructions, feedback).
- Timer: Keeps track of the game’s time, making it easy to modify or extend time-related functionality.
- Utils: Provides general helper functions (input validation).
- Feedback: Stores feedback for each guess (correct/misplaced).

`Data Management`
- SQLiteDB, InitDB, Queries: Handle database operations and game data persistence.

`Configuration and Constants`
- Configuration: Manages game settings ( difficulty, database).
- Constants: Stores constant values (max attempts, code length).

`User Interaction`
- This is handled by helper classes like PrintHelper, which manages all console messages.

`Use of OOP`

- Encapsulation 
Data like the secretCode and guesses are stored in their respective classes. This keeps things organized and easy to maintain.

`Abstraction`
- I abstracted more complex tasks like generating the secret code and giving feedback into helper classes, so the main game logic stays clean and focused.

`Polymorphism`
- The Playable interface allows for consistent methods across different game types. This means I can easily switch or extend the game logic without changing how the game is played.

`Game Features (Extensions)`

- Timer: Tracks and displays the time elapsed.
- HintProvider: Provides hints based on the player's progress.
- DifficultyLevel: Adjusts game difficulty (code length, attempts).

## Example Run
 - Game initializes and selects “0 1 3 5” Player guesses “2 2 4 6”, game responds “all incorrect” Player guesses “0 2 4 6”,
 - game responds “1 correct number and 1 correct location” Player guesses “2 2 1 1”, game responds “1 correct number and 
 - 0 correct location” Player guesses “0 1 5 6”, game responds “3 correct numbers and 2 correct location”

## Instructions How To Build And Start The Game
- Clone repository from GitHub
```
git clone https://github.com/Volodymyr199606/MastermindGame
```
- Build
 ```
cd mastermind
```
```
mvn package
```

- Run
```
java -cp target/mastermind-1.0-SNAPSHOT.jar mastermind.app.Main
```

- Go to project structure and choose `17.0.5-msft 17.0.5-aarch64` poject version

<img width="800" alt="Screenshot 2025-01-08 at 6 37 46 PM" src="https://github.com/user-attachments/assets/feb48589-04da-4d79-b78f-cb652a4a448a" />

<img width="800" alt="Screenshot 2025-01-08 at 6 38 13 PM" src="https://github.com/user-attachments/assets/e939adb2-5736-4105-b8dc-8ccade326400" />



- Navigate to the `target` directory where the compiled `.jar` file is located.
- Run the Main class (which starts the game).
- Once the program starts, follow the on-screen prompts to play the Mastermind game.
- Input your guesses when prompted and try to guess the combination of numbers within 10 attempts!
- Enjoy the Game 🎮

## Database Setup

- Ensure SQLite is installed on your machine.

- Here is a link to download SQLite: https://sqlitebrowser.org/blog/version-3-13-1-released/

- The application uses an SQLite database to store users information.

- Here is Demo instruction
  

https://github.com/user-attachments/assets/1fff7ea1-5590-46aa-8fce-485aa86afe7f



## Database Schema SQLite
- The database file `users.db` will be created automatically when you run the game.

```   
| Column Name | Data Type | Not Null | Default Value | Primary Key | Description                          |
|-------------|-----------|----------|---------------|-------------|--------------------------------------|
| id          | INTEGER   | No       | NULL          | Yes         | A unique identifier for each user.   |
| name        | TEXT      | Yes      | NULL          | No          | The full name of the user.           |
| username    | TEXT      | Yes      | NULL          | No          | The unique username chosen by the user. |
| city        | TEXT      | Yes      | NULL          | No          | The city where the user resides.     |
```

## Dependencies
`mvn dependency:tree`

````
 mastermind.app:mastermind:jar:1.0-SNAPSHOT
[INFO] +- org.junit.jupiter:junit-jupiter-api:jar:5.8.2:test
[INFO] |  +- org.opentest4j:opentest4j:jar:1.2.0:test
[INFO] |  +- org.junit.platform:junit-platform-commons:jar:1.8.2:test
[INFO] |  \- org.apiguardian:apiguardian-api:jar:1.1.2:test
[INFO] +- org.junit.jupiter:junit-jupiter-params:jar:5.8.2:test
[INFO] +- org.xerial:sqlite-jdbc:jar:3.36.0.3:compile
[INFO] \- org.mockito:mockito-core:jar:4.0.0:test
[INFO]    +- net.bytebuddy:byte-buddy:jar:1.11.19:test
[INFO]    +- net.bytebuddy:byte-buddy-agent:jar:1.11.19:test
[INFO]    \- org.objenesis:objenesis:jar:3.2:test

````
# Technologies
1. Programming Language: Java
2. Build Tool: Maven
3. Database: SQLite


# Project Structure
````
MastermindGame/
├── idea/
├── mastermind/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── mastermind/
│   │   │       ├── app/
│   │   │       │   ├── config/
│   │   │       │   │   └── Configuration.java
│   │   │       │   ├── controller/
│   │   │       │   │   ├── Game.java
│   │   │       │   │   ├── GameLogic.java
│   │   │       │   │   └── Playable.java
│   │   │       │   ├── helpers/
│   │   │       │   │   ├── Constants.java
│   │   │       │   │   ├── DifficultyLevel.java
│   │   │       │   │   ├── HintProvider.java
│   │   │       │   │   ├── PrintHelper.java
│   │   │       │   │   ├── Queries.java
│   │   │       │   │   ├── RandomNumberGenerator.java
│   │   │       │   │   ├── Timer.java
│   │   │       │   │   └── Utils.java
│   │   │       │   ├── service/
│   │   │       │   │   └── Feedback.java
│   │   │       │   └── system/
│   │   │       │       ├── InitDB.java
│   │   │       │       └── SQLiteDB.java
│   │   │       └── Main.java
│   └─ test/
│       └── java/
│           └── mastermind/
│               ├── app/
│               │   ├── config/
│               │   │   └── ConfigurationTest.java
│               │   ├── controller/
│               │   │   └── GameTest.java
│               │   ├── helpers/
│               │   │   ├── DifficultyLevelTest.java
│               │   │   ├── HintProviderTest.java
│               │   │   ├── PrintHelperTest.java
│               │   │   ├── QueriesTest.java
│               │   │   ├── RandomNumberGeneratorTest.java
│               │   │   ├── TimerTest.java
│               │   │   └── UtilsTest.java
│               │   ├── service/
│               │   │   └── FeedbackTest.java
│               │   └── system/
│               │       ├── InitDBTest.java
│               │       └── SQLiteDBTest.java
├── pom.xml
├── .gitignore
└── README.md

````
## Extensions
- Hint Feature: Players can request hints during the game.

- Timer: The Timer class measures the total game time and the time taken for each attempt. This adds an element of time
tracking to the game, allowing players to see how long they took to make each guess and complete the game.

- Difficulty Levels: The DifficultyLevel class allows players to choose the difficulty level of the game.
The difficulty level determines the length of the secret code, with options for easy (3 digits), medium (4 digits), and hard (5 digits)

## Challenges
- Issue: The error indicates that the expected and actual values in the testReadResponse method do not match.

<img width="800" alt="Screenshot 2025-01-07 at 9 59 04 AM" src="https://github.com/user-attachments/assets/f45a3636-0097-469a-9457-ac68283d73f9" />


- The original method was closing the input stream without reading any data, resulting in an empty response.

<img width="800" alt="Screenshot 2025-01-07 at 10 12 39 AM" src="https://github.com/user-attachments/assets/05e796bf-86d1-43d9-9a75-a854e7ef0f23" />


- The updated method reads each line from the input stream, appends it to the StringBuilder, and then closes the input stream. This ensures that the response string contains the actual data from the input stream.

<img width="800" alt="Screenshot 2025-01-07 at 10 32 07 AM" src="https://github.com/user-attachments/assets/90c0b9fc-fefd-41c6-95bb-8d4e6aeba836" />



- Fixed: Added a while loop to read each line from the BufferedReader until the end of the stream.
Appended each line to the response StringBuilder, ensuring that the entire response content is captured.
Trimmed the final response string to remove any trailing newline characters.

- This fix ensures that the readResponse method correctly reads and returns the full response from the HttpURLConnection,
matching the expected response format in the test.

## TO DO
- Limit the number of hints based on the difficulty level  (easy  3 hints, medium  2 hints, hard  1 hint)
-  Extend to multi-player mode
-  Keep track of scores
