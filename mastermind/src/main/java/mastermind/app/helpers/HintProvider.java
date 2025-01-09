package mastermind.app.helpers;

import java.util.Random;


/**
 * The HintProvider class provides a method to generate a hint for the secret code.
 * It randomly selects one digit from the secret code and returns it as a hint.
 */
public class HintProvider {

  /**
   * Generates a hint for the given secret code.
   * The hint is a randomly selected digit from the secret code.
   *
   * @param secretCode the secret code for which the hint is to be generated
   * @return a hint string containing one of the digits from the secret code
   */
  public static String getHint(char[] secretCode) {
    int hintIndex = new Random().nextInt(secretCode.length);
    return "Hint: One of the digits in the secret code is " + secretCode[hintIndex];
  }
}
