package mastermind.app.helpers;

public class Constants {

  // DB constants
  public static final String WELCOME_MESSAGE2 = "Welcome to the Mastermind Game!";
  public static final String ENTER_NAME_PROMPT = "Enter your name please: ";
  public static final String WRONG_NAME_INPUT_MESSAGE =
      "Wrong input! Name must contain only letters (2-10 characters).";
  public static final String ENTER_USERNAME_PROMPT = "Enter your user name: ";
  public static final String WRONG_USERNAME_INPUT_MESSAGE =
      "Wrong input! User name must include letters and digits only.";
  public static final String ENTER_CITY_PROMPT = "Enter your city: ";
  public static final String WRONG_CITY_INPUT_MESSAGE =
      "Wrong input! City name must be between 2 and 15 characters and contain only letters.";
  public static final String DATA_INSERTED_MESSAGE = "Data inserted successfully.";
  public static final String STORED_USERS_MESSAGE = "\nStored Users:";
  public static final String NAME_PATTERN = "^[a-zA-Z]{1,9}$";
  public static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{3,15}$";
  public static final String CITY_PATTERN = "^[a-zA-Z ]{2,15}$";
  public static final String TIME_FOR_ATTEMPT_MESSAGE = "Time for this attempt: ";
  public static final String TOTAL_GAME_TIME_MESSAGE = "Total game time: ";

  // Game constants
  public static final String WELCOME_MESSAGE = "Welcome! ";
  public static final String TRY_GUESS_MESSAGE = "Try to guess the secret code.";
  public static final String GAME_RULES_MESSAGE =
      "The computer will randomly select a pattern of 3 different numbers for easy lvl, 4 for medium, and 5 for hard from a total of 8 different numbers (0~7)";
  public static final String ATTEMPTS_MESSAGE = "You have 10 attempts. I will give you feedback after every guess.";
  public static final String ENJOY_GAME_MESSAGE = "Enjoy your game! ";
  public static final String ATTEMPT_MESSAGE = "Attempt ";
  public static final String ENTER_GUESS_MESSAGE = "Enter your guess: ";
  public static final String GAME_OVER_QUIT_MESSAGE = "Game Over! You quit the game.";
  public static final String CONGRATS_MESSAGE = "Congrats! You did it!";
  public static final String GAME_OVER_FAIL_MESSAGE = "The game is over! You failed to guess the secret code. ";
  public static final String SECRET_CODE_MESSAGE = "The secret code was: ";
  public static final String PLAY_AGAIN_PROMPT = "Do you want to play again? (yes/no): ";
  public static final String WRONG_INPUT_YES_NO_MESSAGE =
      "Wrong input! Please enter yes or no to continue or stop the game.";
  public static final String WRONG_INPUT_MESSAGE_3 =
      "Wrong input! Please enter exactly 3 characters (0-7) for your guess. ";
  public static final String WRONG_INPUT_MESSAGE_4 =
      "Wrong input! Please enter exactly 4 characters (0-7) for your guess. ";
  public static final String WRONG_INPUT_MESSAGE_5 =
      "Wrong input! Please enter exactly 5 characters (0-7) for your guess. ";
  public static final String CORRECT_LOCATION_MESSAGE = "Correct location: ";
  public static final String CORRECT_NUMBER_MESSAGE = "Correct number: ";
  public static final String THANK_YOU_MESSAGE = "Thank you for the game";

  // Difficulty level messages
  public static final String CHOOSE_DIFFICULTY_MESSAGE = "Choose the difficulty level:";
  public static final String EASY_LEVEL_MESSAGE = "[1] - Easy (3 digits) ";
  public static final String MEDIUM_LEVEL_MESSAGE = "[2] - Medium (4 digits) ";
  public static final String HARD_LEVEL_MESSAGE = "[3] - Hard (5 digits) ";
  public static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Defaulting to Medium.";

  private Constants() {
    // Private constructor to prevent instantiation
  }
}
