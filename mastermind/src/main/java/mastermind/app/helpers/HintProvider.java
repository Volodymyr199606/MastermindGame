package mastermind.app.helpers;

import java.util.Random;


public class HintProvider {

  public static String getHint(char[] secretCode) {
    int hintIndex = new Random().nextInt(secretCode.length);
    return "Hint: One of the digits in the secret code is " + secretCode[hintIndex];
  }
}
