package mastermind.app.system;




public class InitDB {
  public void init() {
    System.out.println("Initializing database...");
    SQLiteDB db = new SQLiteDB();
    db.connectAndInitialize();
  }
}
