package helpers;

import mastermind.app.helpers.PrintHelper;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class PrintHelperTest {

  @Test
  public void testPrintMessage() {
    String message = "Hello, World!";
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    PrintHelper.printMessage(message);

    assertEquals(message + System.lineSeparator(), outContent.toString());

    System.setOut(originalOut);
  }
}