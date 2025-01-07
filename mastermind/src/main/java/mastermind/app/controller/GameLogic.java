package mastermind.app.controller;

import mastermind.app.helpers.RandomNumberGenerator;


public abstract class GameLogic {
  private int maxAttempts;
  private int codeLength;
  private String wrongInputMessage;
  private RandomNumberGenerator randomNumberGenerator;

  public GameLogic(int maxAttempts) {
    this.maxAttempts = maxAttempts;
    this.randomNumberGenerator = new RandomNumberGenerator();
  }

  public int getMaxAttempts() {
    return maxAttempts;
  }

  public void setMaxAttempts(int maxAttempts) {
    this.maxAttempts = maxAttempts;
  }

  public RandomNumberGenerator getRandomNumberGenerator() {
    return randomNumberGenerator;
  }

  public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }
}