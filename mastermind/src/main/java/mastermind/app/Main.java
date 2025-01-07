package mastermind.app;

import mastermind.app.controller.Game;
import mastermind.app.helpers.Utils;
import mastermind.app.system.InitDB;


public class Main {

  public static void main(String[] args) {

    int maxAttempts = Utils.getMaxAttempts(args);
    Game game = new Game(maxAttempts);
    game.play();

    InitDB initDB = new InitDB();
    initDB.init();
  }
}

