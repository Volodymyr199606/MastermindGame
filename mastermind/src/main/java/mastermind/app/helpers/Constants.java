package mastermind.app.helpers;

public class Constants {



  // DB constants
  public static final String WELCOME_MESSAGE2 = "Welcome to the Mastermind Game!";
  public static final String ENTER_NAME_PROMPT = "Enter your name please: ";
  public static final String WRONG_NAME_INPUT_MESSAGE =
      "Wrong input! Name must start with a capital letter and contain only letters (2-10 characters).";
  public static final String ENTER_USERNAME_PROMPT = "Enter your user name: ";
  public static final String WRONG_USERNAME_INPUT_MESSAGE =
      "Wrong input! User name must include letters and digits only.";
  public static final String ENTER_CITY_PROMPT = "Enter your city: ";
  public static final String WRONG_CITY_INPUT_MESSAGE =
      "Wrong input! City name must be between 2 and 15 characters and contain only letters.";
  public static final String DATA_INSERTED_MESSAGE = "Data inserted successfully.";
  public static final String STORED_USERS_MESSAGE = "\nStored Users:";
  public static final String NAME_PATTERN = "^[A-Z][a-zA-Z]{1,9}$";
  public static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{3,15}$";
  public static final String CITY_PATTERN = "^[a-zA-Z ]{2,15}$";

  private Constants() {
    // Private constructor to prevent instantiation
  }

}
