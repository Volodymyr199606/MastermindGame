package config;

import mastermind.app.config.Configuration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationTest {

  @Test
  public void testCodeLength() {
    assertEquals(4, Configuration.CODE_LENGTH, "CODE_LENGTH should be 4");
  }

  @Test
  public void testMaxAttempts() {
    assertEquals(10, Configuration.MAX_ATTEMPTS, "MAX_ATTEMPTS should be 10");
  }

  @Test
  public void testMaxDigit() {
    assertEquals(7, Configuration.MAX_DIGIT, "MAX_DIGIT should be 7");
  }
}