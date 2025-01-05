package mastermind.app.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static mastermind.app.helpers.Constants.*;
import static mastermind.app.helpers.Queries.*;

public class SQLiteDB {

  private static final String DB_URL = "jdbc:sqlite:users.db";

  public void connectAndInitialize() {
    try {
      Connection conn = DriverManager.getConnection(DB_URL);
      if (conn != null) {
        System.out.println();
        System.out.println("Welcome to the Mastermind Game!");
        createTable(conn);
        insertUser(conn);
        displayUsers(conn);
        conn.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void createTable(Connection conn) throws Exception {
    Statement stmt = conn.createStatement();
    stmt.execute(CREATE_TABLE_SQL);
    stmt.close();
  }

  public void insertUser(Connection conn) throws Exception {
    Scanner scanner = new Scanner(System.in);

    String name = getInput(scanner, NAME_PATTERN, ENTER_NAME_PROMPT, WRONG_NAME_INPUT_MESSAGE);
    String username = getInput(scanner, USERNAME_PATTERN, ENTER_USERNAME_PROMPT, WRONG_USERNAME_INPUT_MESSAGE);
    String city = getInput(scanner, CITY_PATTERN, ENTER_CITY_PROMPT, WRONG_CITY_INPUT_MESSAGE);
    insertUserData(conn, name, username, city);
    System.out.println(DATA_INSERTED_MESSAGE);
  }

  private void insertUserData(Connection conn, String name, String username, String city) throws Exception {
    PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
    pstmt.setString(1, name);
    pstmt.setString(2, username);
    pstmt.setString(3, city);
    pstmt.executeUpdate();
    pstmt.close();
  }

  private String getInput(Scanner scanner, String pattern, String prompt, String errorMessage) {
    Pattern compiledPattern = Pattern.compile(pattern);
    String input;
    Matcher matcher;

    System.out.println(prompt);
    input = scanner.nextLine();
    matcher = compiledPattern.matcher(input);
    while (!matcher.matches()) {
      System.out.println(errorMessage);
      System.out.println(prompt);
      input = scanner.nextLine();
      matcher = compiledPattern.matcher(input);
    }

    return input;
  }

  public void displayUsers(Connection conn) throws Exception {
    Statement stmt = conn.createStatement();
    ResultSet result = stmt.executeQuery(SELECT_SQL);

    System.out.println(STORED_USERS_MESSAGE);
    while (result.next()) {
      System.out.println(("ID: " + result.getInt("id") + ", Name: " + result.getString("name") +
          ", Username: " + result.getString("username") + ", City: " + result.getString("city")));
    }
    System.out.println("");

    result.close();
    stmt.close();
  }

}
