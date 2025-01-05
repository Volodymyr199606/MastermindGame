package mastermind.app.system;



/**
 * Initializes the database by creating an instance of SQLiteDB and calling its connectAndInitialize method.
 */
public class InitDB {
  public void init() {
    System.out.println("Initializing database...");
    SQLiteDB db = new SQLiteDB();
    db.connectAndInitialize();
  }
}
