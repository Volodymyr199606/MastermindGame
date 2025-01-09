package helpers;

import mastermind.app.config.Configuration;
import mastermind.app.helpers.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UtilsTest {

  @Test
  public void testGetMaxAttempts() {
    String[] args = {"-t", "5"};
    int maxAttempts = Utils.getMaxAttempts(args);
    assertEquals(5, maxAttempts, "The maximum number of attempts should be 5");

    args = new String[]{"-t", "abc"};
    maxAttempts = Utils.getMaxAttempts(args);
    assertEquals(Configuration.MAX_ATTEMPTS, maxAttempts, "The maximum number of attempts should be the default value");

    args = new String[]{"-t"};
    maxAttempts = Utils.getMaxAttempts(args);
    assertEquals(Configuration.MAX_ATTEMPTS, maxAttempts, "The maximum number of attempts should be the default value");

    args = new String[]{"-t", "5", "-t", "10"};
    maxAttempts = Utils.getMaxAttempts(args);
    assertEquals(5, maxAttempts, "The maximum number of attempts should be 5");
  }
}