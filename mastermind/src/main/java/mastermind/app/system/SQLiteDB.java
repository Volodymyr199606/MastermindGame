package mastermind.app.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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



}
