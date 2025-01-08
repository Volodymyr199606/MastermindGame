package mastermind.app.helpers;

import java.util.Scanner;

import static mastermind.app.config.Configuration.*;


public class DifficultyLevel {
  public static final int EASY = 1;
  public static final int MEDIUM = 2;
  public static final int HARD = 3;

  private int codeLength;

  public DifficultyLevel() {
    this.codeLength = 4;
  }

  public void askForDifficultyLevel() {
    Scanner scanner = new Scanner(System.in);
    PrintHelper.printMessage(Constants.CHOOSE_DIFFICULTY_MESSAGE);
    PrintHelper.printMessage(Constants.EASY_LEVEL_MESSAGE);
    PrintHelper.printMessage(Constants.MEDIUM_LEVEL_MESSAGE);
    PrintHelper.printMessage(Constants.HARD_LEVEL_MESSAGE);
    int choice = scanner.nextInt();

    switch (choice) {
      case EASY:
        codeLength = CODE_LENGTH_EASY;
        break;
      case MEDIUM:
        codeLength = CODE_LENGTH_MEDIUM;
        break;
      case HARD:
        codeLength = CODE_LENGTH_HARD;
        break;
      default:
        PrintHelper.printMessage(Constants.INVALID_CHOICE_MESSAGE);
        codeLength = 4;
    }
  }

  public int getCodeLength() {
    return codeLength;
  }
}