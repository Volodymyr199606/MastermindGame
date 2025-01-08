package mastermind.app.controller;

import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * An interface for playable objects.
 */
public interface Playable {
  void play();

  int playGame(Scanner scanner, Pattern pattern);

  void printWelcomeMessages();

  String validateInput(Scanner scanner, Pattern pattern, String input);

  boolean promptPlayAgain(Scanner scanner, Pattern yesNoPattern);
}