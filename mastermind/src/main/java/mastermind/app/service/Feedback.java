package mastermind.app.service;

import java.util.HashMap;


public class Feedback {

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
      correctNumber += correctLocation;
    }
    if (correctNumber > 0) {
      return new int[]{correctLocation, correctNumber};
    } else {
      return new int[]{0, 0};
    }
  }
}
