package mastermind.app.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;


public class RandomNumberGenerator {

  private static final String API_URL_TEMPLATE =
      "https://www.random.org/integers/?num=%d&min=0&max=7&col=1&base=10&format=plain&rnd=new";

  public String generateNumber(int codeLength) {
    try {
      String response = fetchRandomNumberFromAPI(codeLength);
      if (response != null) {
        // Ensure the response contains only valid digits and has the correct length
        StringBuilder validNumber = new StringBuilder();
        for (char c : response.toCharArray()) {
          if (c >= '0' && c <= '7') {
            validNumber.append(c);
          }
          if (validNumber.length() == codeLength) {
            break;
          }
        }
        if (validNumber.length() == codeLength) {
          return validNumber.toString();
        }
      }
    } catch (Exception e) {
      System.out.println(
          "No connection to the API, the program will generate random number locally: " + e.getMessage());
    }

    // Fallback to local random number generation
    return generateLocalRandomNumber(codeLength);
  }

  private String fetchRandomNumberFromAPI(int codeLength) throws Exception {
    String apiUrl = String.format(API_URL_TEMPLATE, codeLength);
    URL url = new URL(apiUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    int responseCode = connection.getResponseCode();

    if (responseCode == HttpURLConnection.HTTP_OK) {
      return readResponse(connection);
    } else {
      System.out.println("GET request failed. Response Code: " + responseCode);
      return null;
    }
  }

  public String readResponse(HttpURLConnection connection) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder response = new StringBuilder();
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine).append("\n");
    }
    in.close();
    return response.toString().trim();
  }

  public String generateLocalRandomNumber(int codeLength) {
    Random random = new Random();
    StringBuilder localRandomNumber = new StringBuilder();
    for (int i = 0; i < codeLength; i++) {
      localRandomNumber.append(random.nextInt(8));
    }
    return localRandomNumber.toString();
  }
}