package helpers;

import mastermind.app.config.Configuration;
import mastermind.app.helpers.Utils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

  @Test
  public void testGetMaxAttemptsWithValidArgument() {
    String[] args = {"-t", "5"};
    int result = Utils.getMaxAttempts(args);
    assertEquals(5, result);
  }

  @Test
  public void testGetMaxAttemptsWithInvalidArgument() {
    String[] args = {"-t", "invalid"};
    int result = Utils.getMaxAttempts(args);
    assertEquals(Configuration.MAX_ATTEMPTS, result);
  }

  @Test
  public void testGetMaxAttemptsWithNoArgument() {
    String[] args = {};
    int result = Utils.getMaxAttempts(args);
    assertEquals(Configuration.MAX_ATTEMPTS, result);
  }

  @Test
  public void testGetMaxAttemptsWithNoValueAfterFlag() {
    String[] args = {"-t"};
    int result = Utils.getMaxAttempts(args);
    assertEquals(Configuration.MAX_ATTEMPTS, result);
  }
}