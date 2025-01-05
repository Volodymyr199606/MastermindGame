package mastermind.app.helpers;

public class Queries {
  public static final String CREATE_TABLE_SQL =
      "CREATE TABLE IF NOT EXISTS users (\n" + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
          + "    name TEXT NOT NULL,\n" + "    username TEXT NOT NULL,\n" + "    city TEXT NOT NULL\n" + ");";
  public static final String INSERT_SQL = "INSERT INTO users (name, username, city) VALUES (?, ?, ?);";
  public static final String SELECT_SQL = "SELECT * FROM users;";
}