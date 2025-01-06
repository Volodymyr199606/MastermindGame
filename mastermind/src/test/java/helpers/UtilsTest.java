package helpers;

import mastermind.app.config.Configuration;
import mastermind.app.helpers.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UtilsTest {

  @Test
  public void testGenerateSecretCode() {
    char[] secretCode = Utils.generateSecretCode();
    assertNotNull(secretCode, "Secret code should not be null");
    assertEquals(Configuration.CODE_LENGTH, secretCode.length, "Secret code should have the correct length");

    for (char c : secretCode) {
      assertTrue(c >= '0' && c <= '7', "Each character should be a digit between 0 and 7");
    }
  }
}