package system;

import mastermind.app.system.SQLiteDB;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.mockito.Mockito.*;

public class SQLiteDBTest {

  @Mock
  private Connection mockConnection;

  @Mock
  private Statement mockStatement;

  @Mock
  private PreparedStatement mockPreparedStatement;

  @Mock
  private ResultSet mockResultSet;

  private SQLiteDB sqliteDB;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);
    sqliteDB = new SQLiteDB();
    when(mockConnection.createStatement()).thenReturn(mockStatement);
    when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
  }

  @Test
  public void testCreateTable() throws Exception {
    sqliteDB.createTable(mockConnection);
    verify(mockStatement, times(1)).execute(anyString());
    verify(mockStatement, times(1)).close();
  }

  @Test
  public void testInsertUserData() throws Exception {
    sqliteDB.insertUserData(mockConnection, "John Doe", "johndoe", "New York");
    verify(mockPreparedStatement, times(1)).setString(1, "John Doe");
    verify(mockPreparedStatement, times(1)).setString(2, "johndoe");
    verify(mockPreparedStatement, times(1)).setString(3, "New York");
    verify(mockPreparedStatement, times(1)).executeUpdate();
    verify(mockPreparedStatement, times(1)).close();
  }

  @Test
  public void testDisplayUsers() throws Exception {
    when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
    when(mockResultSet.next()).thenReturn(true).thenReturn(false);
    when(mockResultSet.getInt("id")).thenReturn(1);
    when(mockResultSet.getString("name")).thenReturn("John Doe");
    when(mockResultSet.getString("username")).thenReturn("johndoe");
    when(mockResultSet.getString("city")).thenReturn("New York");

    sqliteDB.displayUsers(mockConnection);

    verify(mockStatement, times(1)).executeQuery(anyString());
    verify(mockResultSet, times(2)).next();
    verify(mockResultSet, times(1)).getInt("id");
    verify(mockResultSet, times(1)).getString("name");
    verify(mockResultSet, times(1)).getString("username");
    verify(mockResultSet, times(1)).getString("city");
    verify(mockResultSet, times(1)).close();
    verify(mockStatement, times(1)).close();
  }
}