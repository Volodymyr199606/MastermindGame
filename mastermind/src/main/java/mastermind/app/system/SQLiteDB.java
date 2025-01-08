package mastermind.app.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mastermind.app.helpers.PrintHelper;

import static mastermind.app.helpers.Constants.*;
import static mastermind.app.helpers.Queries.*;


/**
 * This class handles the SQLite database operations such as connecting to the database,
 * creating tables, inserting user data, and displaying stored users.
 */
public class SQLiteDB {

  private static final String DB_URL = "jdbc:sqlite:users.db";

  /**
   * Connects to the SQLite database and initializes it by creating the necessary table,
   * inserting user data, and displaying the stored users.
   */
  public void connectAndInitialize() {
    try {
      Connection conn = DriverManager.getConnection(DB_URL);
      if (conn != null) {
        System.out.println();
        System.out.println(WELCOME_MESSAGE2);
        createTable(conn);
        insertUser(conn);
        displayUsers(conn);
        conn.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates the users table in the database.
   *
   * @param conn The database connection
   * @throws Exception If an error occurs while creating the table
   */
  public void createTable(Connection conn) throws Exception {
    Statement stmt = conn.createStatement();
    stmt.execute(CREATE_TABLE_SQL);
    stmt.close();
  }

  /**
   * Prompts the user for their name, username, and city, and inserts this data into the database.
   *
   * @param conn The database connection
   * @throws Exception If an error occurs while inserting the user data
   */
  public void insertUser(Connection conn) throws Exception {
    Scanner scanner = new Scanner(System.in);

    String name = getInput(scanner, NAME_PATTERN, ENTER_NAME_PROMPT, WRONG_NAME_INPUT_MESSAGE);
    name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    String username = getInput(scanner, USERNAME_PATTERN, ENTER_USERNAME_PROMPT, WRONG_USERNAME_INPUT_MESSAGE);
    String city = getInput(scanner, CITY_PATTERN, ENTER_CITY_PROMPT, WRONG_CITY_INPUT_MESSAGE);
    insertUserData(conn, name, username, city);
    PrintHelper.printMessage(DATA_INSERTED_MESSAGE);
  }

  /**
   * Inserts the user data into the users table.
   *
   * @param conn The database connection
   * @param name The user's name
   * @param username The user's username
   * @param city The user's city
   * @throws Exception If an error occurs while inserting the user data
   */
  public void insertUserData(Connection conn, String name, String username, String city) throws Exception {
    PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
    pstmt.setString(1, name);
    pstmt.setString(2, username);
    pstmt.setString(3, city);
    pstmt.executeUpdate();
    pstmt.close();
  }

  /**
   * Prompts the user for input and validates it against a specified pattern.
   *
   * @param scanner The scanner to read user input
   * @param pattern The regex pattern to validate the input
   * @param prompt The prompt message to display to the user
   * @param errorMessage The error message to display if the input is invalid
   * @return The validated user input
   */
  private String getInput(Scanner scanner, String pattern, String prompt, String errorMessage) {
    Pattern compiledPattern = Pattern.compile(pattern);
    String input;
    Matcher matcher;

    PrintHelper.printMessage(prompt);
    input = scanner.nextLine();
    matcher = compiledPattern.matcher(input);
    while (!matcher.matches()) {
      PrintHelper.printMessage(errorMessage);
      PrintHelper.printMessage(prompt);
      input = scanner.nextLine();
      matcher = compiledPattern.matcher(input);
    }

    return input;
  }

  /**
   * Displays the stored users from the users table.
   *
   * @param conn The database connection
   * @throws Exception If an error occurs while retrieving the user data
   */
  public void displayUsers(Connection conn) throws Exception {
    Statement stmt = conn.createStatement();
    ResultSet result = stmt.executeQuery(SELECT_SQL);

    PrintHelper.printMessage(STORED_USERS_MESSAGE);
    while (result.next()) {
      PrintHelper.printMessage(
          "ID: " + result.getInt("id") + ", Name: " + result.getString("name") + ", Username: " + result.getString(
              "username") + ", City: " + result.getString("city"));
    }
    PrintHelper.printMessage("");

    result.close();
    stmt.close();
  }
}
