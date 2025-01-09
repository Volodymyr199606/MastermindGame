package mastermind.app.controller;

import mastermind.app.helpers.HintProvider;
import mastermind.app.helpers.RandomNumberGenerator;
import mastermind.app.helpers.Timer;


public abstract class GameLogic implements Playable {
  private int maxAttempts;
  private int codeLength;
  private String wrongInputMessage;
  private RandomNumberGenerator randomNumberGenerator;
  private Timer gameTimer;
  private Timer attemptTimer;
  private HintProvider hintProvider;

  public GameLogic(int maxAttempts) {
    this.maxAttempts = maxAttempts;
    this.randomNumberGenerator = new RandomNumberGenerator();
    this.gameTimer = new Timer();
    this.attemptTimer = new Timer();
    this.hintProvider = new HintProvider();
  }

  public int getMaxAttempts() {
    return maxAttempts;
  }

  public void setMaxAttempts(int maxAttempts) {
    this.maxAttempts = maxAttempts;
  }

  public int getCodeLength() {
    return codeLength;
  }

  public void setCodeLength(int codeLength) {
    this.codeLength = codeLength;
  }

  public String getWrongInputMessage() {
    return wrongInputMessage;
  }

  public void setWrongInputMessage(String wrongInputMessage) {
    this.wrongInputMessage = wrongInputMessage;
  }

  public RandomNumberGenerator getRandomNumberGenerator() {
    return randomNumberGenerator;
  }

  public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }

  public Timer getGameTimer() {
    return gameTimer;
  }

  public void setGameTimer(Timer gameTimer) {
    this.gameTimer = gameTimer;
  }

  public Timer getAttemptTimer() {
    return attemptTimer;
  }

  public void setAttemptTimer(Timer attemptTimer) {
    this.attemptTimer = attemptTimer;
  }

  public HintProvider getHintProvider() {
    return hintProvider;
  }

  public void setHintProvider(HintProvider hintProvider) {
    this.hintProvider = hintProvider;
  }
}