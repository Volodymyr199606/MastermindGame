package controller;

import mastermind.app.controller.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.regex.Pattern;

import static mastermind.app.helpers.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
  private Game game;

  @BeforeEach
  public void setUp() {
    game = new Game(10);
  }

  @Test
  public void testSetWrongInputMessage() {
    game.setCodeLength(3);
    game.setWrongInputMessage();
    assertEquals(WRONG_INPUT_MESSAGE_3, game.getWrongInputMessage());

    game.setCodeLength(4);
    game.setWrongInputMessage();
    assertEquals(WRONG_INPUT_MESSAGE_4, game.getWrongInputMessage());

    game.setCodeLength(5);
    game.setWrongInputMessage();
    assertEquals(WRONG_INPUT_MESSAGE_5, game.getWrongInputMessage());
  }

  @Test
  public void testValidateInput() {
    Scanner scanner = new Scanner("1234\n");
    Pattern pattern = Pattern.compile("^[0-7]{4}$");
    game.setCodeLength(4);
    game.setWrongInputMessage(WRONG_INPUT_MESSAGE_4);

    String input = game.validateInput(scanner, pattern, "1234");
    assertEquals("1234", input);
  }

  @Test
  public void testPrintWelcomeMessages() {
    game.printWelcomeMessages();
  }

  @Test
  public void testPromptPlayAgain() {
    Scanner scanner = new Scanner("yes\n");
    Pattern yesNoPattern = Pattern.compile("^(yes|no)$", Pattern.CASE_INSENSITIVE);

    boolean playAgain = game.promptPlayAgain(scanner, yesNoPattern);
    assertTrue(playAgain);

    scanner = new Scanner("no\n");
    playAgain = game.promptPlayAgain(scanner, yesNoPattern);
    assertFalse(playAgain);
  }
}