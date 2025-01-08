package mastermind.app.helpers;

import java.util.Scanner;

import static mastermind.app.config.Configuration.*;


/**
 * The DifficultyLevel class is responsible for setting the code length based on the selected difficulty level.
 * It provides options for easy, medium, and hard levels, and sets the code length accordingly.
 */
public class DifficultyLevel {
  public static final int EASY = 1;
  public static final int MEDIUM = 2;
  public static final int HARD = 3;

  private int codeLength;

  /**
   * Constructs a DifficultyLevel object with a default code length of 4.
   */
  public DifficultyLevel() {
    this.codeLength = 4;
  }

  /**
   * Prompts the user to select a difficulty level and sets the code length based on the user's choice.
   * If an invalid choice is made, the default code length of 4 is set.
   */
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

  /**
   * Returns the current code length.
   *
   * @return the code length
   */
  public int getCodeLength() {
    return codeLength;
  }
}