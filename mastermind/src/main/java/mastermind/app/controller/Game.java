package mastermind.app.controller;

import mastermind.app.helpers.RandomNumberGenerator;


public class Game extends GameLogic {
  private char[] secretCode;

  public Game(int maxAttempts) {
    super(maxAttempts);
    setRandomNumberGenerator(new RandomNumberGenerator());
    setMaxAttempts(maxAttempts);
  }
}
