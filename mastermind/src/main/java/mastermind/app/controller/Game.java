package mastermind.app.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import mastermind.app.helpers.RandomNumberGenerator;

import static mastermind.app.helpers.Constants.*;


public class Game extends GameLogic {
  private char[] secretCode;

  public Game(int maxAttempts) {
    super(maxAttempts);
    setRandomNumberGenerator(new RandomNumberGenerator());
    setMaxAttempts(maxAttempts);
  }

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

    }

    scanner.close();
  }

  private void setWrongInputMessage() {
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

  public void printWelcomeMessages() {
    System.out.println();
    System.out.println(WELCOME_MESSAGE);
    System.out.println(TRY_GUESS_MESSAGE);
    System.out.println(GAME_RULES_MESSAGE);
    System.out.println(ATTEMPTS_MESSAGE);
    System.out.println(ENJOY_GAME_MESSAGE);
  }

  public int playGame(Scanner scanner, Pattern pattern) {
    int correctLocation = 0;
    return correctLocation;
  }
}