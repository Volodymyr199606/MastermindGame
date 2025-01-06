package mastermind.app.helpers;

import java.util.Random;
import mastermind.app.config.Configuration;


public class Utils {

  public static int getMaxAttempts(String[] args) {
    int maxAttempts = Configuration.MAX_ATTEMPTS;
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-t") && i + 1 < args.length) {
        try {
          maxAttempts = Integer.parseInt(args[i + 1]);
        } catch (NumberFormatException e) {
          System.out.println("Invalid number of attempts provided. Using default value: " + Configuration.MAX_ATTEMPTS);
        }
        break;
      }
    }
    return maxAttempts;
  }

  public static char[] generateSecretCode() {
    Random random = new Random();
    char[] secretCode = new char[Configuration.CODE_LENGTH];
    for (int i = 0; i < Configuration.CODE_LENGTH; i++) {
      secretCode[i] = (char) ('0' + random.nextInt(Configuration.MAX_DIGIT + 1));
    }
    return secretCode;
  }
}
