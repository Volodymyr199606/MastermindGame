package helpers;

import mastermind.app.helpers.Queries;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueriesTest {

  @Test
  public void testCreateTableSql() {
    String expected = "CREATE TABLE IF NOT EXISTS users (\n" +
        "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
        "    name TEXT NOT NULL,\n" +
        "    username TEXT NOT NULL,\n" +
        "    city TEXT NOT NULL\n" +
        ");";
    assertEquals(expected, Queries.CREATE_TABLE_SQL, "CREATE_TABLE_SQL should match the expected query");
  }

  @Test
  public void testInsertSql() {
    String expected = "INSERT INTO users (name, username, city) VALUES (?, ?, ?);";
    assertEquals(expected, Queries.INSERT_SQL, "INSERT_SQL should match the expected query");
  }

  @Test
  public void testSelectSql() {
    String expected = "SELECT * FROM users;";
    assertEquals(expected, Queries.SELECT_SQL, "SELECT_SQL should match the expected query");
  }
}