package helpers;

import mastermind.app.helpers.DifficultyLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static mastermind.app.config.Configuration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifficultyLevelTest {

  private DifficultyLevel difficultyLevel;

  @BeforeEach
  public void setUp() {
    difficultyLevel = new DifficultyLevel();
  }

  @Test
  public void testDefaultCodeLength() {
    assertEquals(4, difficultyLevel.getCodeLength());
  }

  @Test
  public void testEasyLevel() {
    String input = "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    difficultyLevel.askForDifficultyLevel();
    assertEquals(CODE_LENGTH_EASY, difficultyLevel.getCodeLength());
  }

  @Test
  public void testMediumLevel() {
    String input = "2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    difficultyLevel.askForDifficultyLevel();
    assertEquals(CODE_LENGTH_MEDIUM, difficultyLevel.getCodeLength());
  }

  @Test
  public void testHardLevel() {
    String input = "3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    difficultyLevel.askForDifficultyLevel();
    assertEquals(CODE_LENGTH_HARD, difficultyLevel.getCodeLength());
  }

  @Test
  public void testInvalidChoice() {
    String input = "4";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    difficultyLevel.askForDifficultyLevel();
    assertEquals(4, difficultyLevel.getCodeLength());
  }
}