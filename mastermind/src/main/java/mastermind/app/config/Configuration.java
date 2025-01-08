package mastermind.app.config;

/**
 * The Configuration class holds the configuration constants for the application.
 * It includes constants for the code length, maximum attempts, and maximum digit.
 * This class cannot be instantiated.
 */
public final class Configuration {
  public static final int CODE_LENGTH = 4;
  public static final int CODE_LENGTH_EASY = 3;
  public static final int CODE_LENGTH_MEDIUM = 4;
  public static final int CODE_LENGTH_HARD = 5;
  public static final int MAX_ATTEMPTS = 10;
  public static final int MAX_DIGIT = 7;

  // Private constructor to prevent instantiation
  private Configuration() {
  }
}