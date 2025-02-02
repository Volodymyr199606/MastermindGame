package mastermind.app.service;

import java.util.HashMap;


public class Feedback {

  /**
   * Calculates the feedback for a given guess in the Mastermind game.
   *
   * @param secretCode the secret code to be guessed
   * @param guess the player's guess
   * @param codeLength the length of the code
   * @return an array where the first element is the number of correct digits in the correct location,
   *         and the second element is the total number of correct digits (including correct locations)
   */
  public static int[] calculateFeedback(char[] secretCode, char[] guess, int codeLength) {
    int correctLocation = 0;
    int correctNumber = 0;
    boolean[] correctLocations = new boolean[codeLength];
    HashMap<Character, Integer> secretCodeMap = new HashMap<>();
    for (int i = 0; i < codeLength; i++) {
      if (secretCode[i] == guess[i]) {
        correctLocation++;
        correctLocations[i] = true;
      } else {
        secretCodeMap.put(secretCode[i], secretCodeMap.getOrDefault(secretCode[i], 0) + 1);
      }
    }
    for (int i = 0; i < codeLength; i++) {
      if (!correctLocations[i] && secretCodeMap.containsKey(guess[i]) && secretCodeMap.get(guess[i]) > 0) {
        correctNumber++;
        secretCodeMap.put(guess[i], secretCodeMap.get(guess[i]) - 1);
      }
    }

    correctNumber += correctLocation;

    if (correctNumber > 0) {
      return new int[]{correctLocation, correctNumber};
    } else {
      return new int[]{0, 0};
    }
  }
}
