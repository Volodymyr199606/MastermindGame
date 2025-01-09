package mastermind.app.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mastermind.app.helpers.DifficultyLevel;
import mastermind.app.helpers.HintProvider;
import mastermind.app.helpers.RandomNumberGenerator;
import mastermind.app.service.Feedback;
import mastermind.app.helpers.Timer;

import static mastermind.app.helpers.Constants.*;


/**
 * The Game class extends GameLogic and implements the main game loop for the Mastermind game.
 * It handles user input, game logic, and provides feedback to the player.
 */
public class Game extends GameLogic {
  private char[] secretCode;

  /**
   * Constructs a Game object with the specified maximum number of attempts.
   *
   * @param maxAttempts the maximum number of attempts allowed in the game
   */
  public Game(int maxAttempts) {
    super(maxAttempts);
    setRandomNumberGenerator(new RandomNumberGenerator());
    setMaxAttempts(maxAttempts);
    setGameTimer(new Timer());
    setAttemptTimer(new Timer());
    setHintProvider(new HintProvider());
  }

  /**
   * Starts the game loop, allowing the player to play multiple rounds until they choose to quit.
   */
  @Override
  public void play() {
    Scanner scanner = new Scanner(System.in);
    boolean playAgain = true;
    Pattern pattern;
    Pattern yesNoPattern = Pattern.compile("^(yes|no)$", Pattern.CASE_INSENSITIVE);

    while (playAgain) {
      DifficultyLevel difficultyLevel = new DifficultyLevel();
      difficultyLevel.askForDifficultyLevel();
      setCodeLength(difficultyLevel.getCodeLength());
      pattern = Pattern.compile("^[0-7]*{" + getCodeLength() + "}$");

      setWrongInputMessage();

      secretCode = getRandomNumberGenerator().generateNumber(getCodeLength()).toCharArray();

      printWelcomeMessages();

      getGameTimer().start();
      int correctLocation = playGame(scanner, pattern);
      getGameTimer().stop();

      if (correctLocation != getCodeLength()) {
        System.out.println();
        System.out.println(GAME_OVER_FAIL_MESSAGE);
      }
      System.out.println(SECRET_CODE_MESSAGE + Arrays.toString(secretCode));
      System.out.println();
      System.out.println(TOTAL_GAME_TIME_MESSAGE + getGameTimer().getFormattedElapsedTime());

      playAgain = promptPlayAgain(scanner, yesNoPattern);
    }

    scanner.close();
  }

  /**
   * Sets the appropriate wrong input message based on the current code length.
   */
  public void setWrongInputMessage() {
    switch (getCodeLength()) {
      case 3:
        setWrongInputMessage(WRONG_INPUT_MESSAGE_3);
        break;
      case 4:
        setWrongInputMessage(WRONG_INPUT_MESSAGE_4);
        break;
      case 5:
        setWrongInputMessage(WRONG_INPUT_MESSAGE_5);
        break;
    }
  }

  /**
   * Validates and processes the user's input, providing hints if requested.
   *
   * @param scanner the Scanner object for reading user input
   * @param inputPattern the pattern to validate the input against
   * @param input the user's input
   * @param attempt the current attempt number
   * @return the validated input
   */
  private String validateAndProcessInput(Scanner scanner, Pattern inputPattern, String input, int attempt) {
    while (input.isEmpty() || !inputPattern.matcher(input).matches() || input.length() != getCodeLength()) {
      if (input.equals("h")) {
        System.out.println(getHintProvider().getHint(secretCode));
        attempt--;
        System.out.print(ENTER_GUESS_MESSAGE);
        input = scanner.nextLine();
        continue;
      }
      System.out.println(getWrongInputMessage());
      System.out.print(ENTER_GUESS_MESSAGE);
      input = scanner.nextLine();
    }
    return input;
  }

  /**
   * Plays a single round of the game, allowing the player to make guesses and receive feedback.
   *
   * @param scanner the Scanner object for reading user input
   * @param pattern the pattern to validate the input against
   * @return the number of correct locations in the final guess
   */
  @Override
  public int playGame(Scanner scanner, Pattern pattern) {
    int correctLocation = 0;
    Pattern inputPattern = Pattern.compile("^[0-7]*{" + getCodeLength() + "}|h$");

    for (int attempt = 1; attempt <= getMaxAttempts(); attempt++) {
      System.out.println("------------");
      System.out.println(ATTEMPT_MESSAGE + attempt);
      System.out.print(ENTER_GUESS_MESSAGE);

      getAttemptTimer().start();
      String input = scanner.nextLine();
      getAttemptTimer().stop();

      input = validateAndProcessInput(scanner, inputPattern, input, attempt);

      if (input.equals("h")) {
        continue;
      }

      input = validateInput(scanner, pattern, input);

      char[] guess = input.toCharArray();
      int[] feedback = Feedback.calculateFeedback(secretCode, guess, getCodeLength());
      correctLocation = feedback[0];
      int correctNumber = feedback[1];

      if (correctLocation == getCodeLength()) {
        System.out.println(CONGRATS_MESSAGE);
        break;
      } else {
        System.out.println(CORRECT_LOCATION_MESSAGE + correctLocation);
        System.out.println(CORRECT_NUMBER_MESSAGE + correctNumber);
      }
      System.out.println();
      System.out.println(TIME_FOR_ATTEMPT_MESSAGE + getAttemptTimer().getFormattedElapsedTime());
    }

    return correctLocation;
  }

  /**
   * Prints the welcome messages at the start of the game.
   */
  @Override
  public void printWelcomeMessages() {
    System.out.println();
    System.out.println(WELCOME_MESSAGE);
    System.out.println();
    System.out.println(TRY_GUESS_MESSAGE);
    System.out.println(GAME_RULES_MESSAGE);
    System.out.println(ATTEMPTS_MESSAGE);
    System.out.println();
    System.out.println(PRESS_H_FOR_HINT_MESSAGE);
    System.out.println(ENJOY_GAME_MESSAGE);
  }

  /**
   * Validates the user's input against the specified pattern.
   *
   * @param scanner the Scanner object for reading user input
   * @param pattern the pattern to validate the input against
   * @param input the user's input
   * @return the validated input
   */
  @Override
  public String validateInput(Scanner scanner, Pattern pattern, String input) {
    Matcher matcher = pattern.matcher(input);
    while (!matcher.matches()) {
      System.out.println(getWrongInputMessage());
      System.out.print(CONGRATS_MESSAGE);
      input = scanner.nextLine();
      matcher = pattern.matcher(input);
    }
    return input;
  }

  /**
   * Prompts the player to decide whether to play again.
   *
   * @param scanner the Scanner object for reading user input
   * @param yesNoPattern the pattern to validate the yes/no input
   * @return true if the player wants to play again, false otherwise
   */
  public boolean promptPlayAgain(Scanner scanner, Pattern yesNoPattern) {
    System.out.println();
    System.out.print(PLAY_AGAIN_PROMPT);
    System.out.println();
    String response = scanner.nextLine();
    Matcher yesNoMatcher = yesNoPattern.matcher(response);
    while (!yesNoMatcher.matches()) {
      System.out.println(WRONG_INPUT_YES_NO_MESSAGE);
      System.out.print(PLAY_AGAIN_PROMPT);
      response = scanner.nextLine();
      yesNoMatcher = yesNoPattern.matcher(response);
    }

    if (response.equalsIgnoreCase("no")) {
      System.out.println(THANK_YOU_MESSAGE);
    }

    return response.equalsIgnoreCase("yes");
  }
}