package mastermind.app.helpers;

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
}
