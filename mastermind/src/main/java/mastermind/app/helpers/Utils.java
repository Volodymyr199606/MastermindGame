package mastermind.app.helpers;

import mastermind.app.config.Configuration;


/**
 * The Utils class provides utility methods for the game.
 * It includes methods to get the maximum number of attempts from command-line arguments
 * and to generate a secret code for the game.
 */
public class Utils {

  /**
   * Retrieves the maximum number of attempts from the command-line arguments.
   * If the argument is not provided or is invalid, it returns the default value from the configuration.
   *
   * @param args The command-line arguments
   * @return The maximum number of attempts
   */
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