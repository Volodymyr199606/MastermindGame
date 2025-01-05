package system;
import mastermind.app.system.InitDB;
import mastermind.app.system.SQLiteDB;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class InitDBTest {

  @Test
  public void testInit() {
    // Arrange
    SQLiteDB mockDb = mock(SQLiteDB.class);
    InitDB initDB = new InitDB() {
      @Override
      public void init() {
        System.out.println("Initializing database...");
        mockDb.connectAndInitialize();
      }
    };

    // Act
    initDB.init();

    // Assert
    verify(mockDb, times(1)).connectAndInitialize();
  }
}