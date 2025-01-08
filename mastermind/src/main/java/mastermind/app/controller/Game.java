package mastermind.app.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mastermind.app.helpers.RandomNumberGenerator;
import mastermind.app.service.Feedback;

import static mastermind.app.helpers.Constants.*;


public class Game extends GameLogic {
  private char[] secretCode;

  public Game(int maxAttempts) {
    super(maxAttempts);
    setRandomNumberGenerator(new RandomNumberGenerator());
    setMaxAttempts(maxAttempts);
  }

  @Override
  public void play() {
    Scanner scanner = new Scanner(System.in);
    boolean playAgain = true;
    Pattern pattern;
    Pattern yesNoPattern = Pattern.compile("^(yes|no)$", Pattern.CASE_INSENSITIVE);

    while (playAgain) {
      setCodeLength(getCodeLength());
      pattern = Pattern.compile("^[0-7]*{" + getCodeLength() + "}$");

      setWrongInputMessage();

      secretCode = getRandomNumberGenerator().generateNumber(getCodeLength()).toCharArray();

      printWelcomeMessages();

      int correctLocation = playGame(scanner, pattern);

      if (correctLocation != getCodeLength()) {
        System.out.println();
        System.out.println(GAME_OVER_FAIL_MESSAGE);
      }
      System.out.println(SECRET_CODE_MESSAGE + Arrays.toString(secretCode));

      playAgain = promptPlayAgain(scanner, yesNoPattern);
    }

    scanner.close();
  }

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

  public String validateAndProcessInput(Scanner scanner, Pattern inputPattern, String input, int attempt) {
    while (input.isEmpty() || !inputPattern.matcher(input).matches() || input.length() != getCodeLength()) {
      if (input.equals("")) {
        System.out.println(secretCode);
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

  @Override
  public int playGame(Scanner scanner, Pattern pattern) {
    int correctLocation = 0;
    Pattern inputPattern = Pattern.compile("^[0-7]*{" + getCodeLength() + "}|h$");

    for (int attempt = 1; attempt <= getMaxAttempts(); attempt++) {
      System.out.println("------------");
      System.out.println(ATTEMPT_MESSAGE + attempt);
      System.out.print(ENTER_GUESS_MESSAGE);

      String input = scanner.nextLine();

      input = validateAndProcessInput(scanner, inputPattern, input, attempt);

      if (input.equals("quit")) {
        System.out.println(GAME_OVER_QUIT_MESSAGE);
        break;
      } else if (input.equals("h")) {
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
    }

    return correctLocation;
  }

  @Override
  public void printWelcomeMessages() {
    System.out.println();
    System.out.println(WELCOME_MESSAGE);
    System.out.println(TRY_GUESS_MESSAGE);
    System.out.println(GAME_RULES_MESSAGE);
    System.out.println(ATTEMPTS_MESSAGE);
    System.out.println(ENJOY_GAME_MESSAGE);
  }

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

  public boolean promptPlayAgain(Scanner scanner, Pattern yesNoPattern) {
    System.out.println();
    System.out.print(PLAY_AGAIN_PROMPT);
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