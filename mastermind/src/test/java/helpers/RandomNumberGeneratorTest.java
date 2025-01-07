package helpers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import mastermind.app.helpers.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class RandomNumberGeneratorTest {
  @Test
  public void testGenerateNumber() {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    String number = rng.generateNumber(4);
    assertNotNull(number, "Generated number should not be null");
    assertEquals(4, number.length(), "Generated number should have a length of 4");
    for (char c : number.toCharArray()) {
      assertTrue(c >= '0' && c <= '7', "Each character should be a digit between 0 and 7");
    }
  }

  @Test
  public void testGenerateNumberWithDifferentLengths() {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    int[] lengths = {3, 4, 5};
    for (int length : lengths) {
      String number = rng.generateNumber(length);
      assertNotNull(number, "Generated number should not be null");
      assertEquals(length, number.length(), "Generated number should have a length of " + length);
      for (char c : number.toCharArray()) {
        assertTrue(c >= '0' && c <= '7', "Each character should be a digit between 0 and 7");
      }
    }
  }

  @Test
  public void testGenerateLocalRandomNumber() {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    String localNumber = rng.generateLocalRandomNumber(4);
    assertNotNull(localNumber, "Local random number should not be null");
    assertEquals(4, localNumber.length(), "Local random number should have a length of 4");
    for (char c : localNumber.toCharArray()) {
      assertTrue(c >= '0' && c <= '7', "Each character should be a digit between 0 and 7");
    }
  }

  @Test
  public void testGenerateLocalRandomNumberWithDifferentLengths() {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    int[] lengths = {3, 4, 5};
    for (int length : lengths) {
      String localNumber = rng.generateLocalRandomNumber(length);
      assertNotNull(localNumber, "Local random number should not be null");
      assertEquals(length, localNumber.length(), "Local random number should have a length of " + length);
      for (char c : localNumber.toCharArray()) {
        assertTrue(c >= '0' && c <= '7', "Each character should be a digit between 0 and 7");
      }
    }
  }

  @Test
  public void testGenerateSecretCode() {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    char[] secretCode = rng.generateLocalRandomNumber(4).toCharArray();
    assertNotNull(secretCode, "Secret code should not be null");
    assertEquals(4, secretCode.length, "Secret code should have a length of 4");
    for (char c : secretCode) {
      assertTrue(c >= '0' && c <= '7', "Each character should be a digit between 0 and 7");
    }
  }

  @Test
  public void testReadResponse() throws Exception {
    HttpURLConnection connection = mock(HttpURLConnection.class);
    String sampleResponse = "line1\nline2\nline3";
    InputStream inputStream = new ByteArrayInputStream(sampleResponse.getBytes());
    when(connection.getInputStream()).thenReturn(inputStream);
    RandomNumberGenerator rng = new RandomNumberGenerator();
    String response = rng.readResponse(connection);
    assertEquals("line1\nline2\nline3", response);
  }
}
