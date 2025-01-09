package mastermind.app.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;


/**
 * The RandomNumberGenerator class provides methods to generate random numbers.
 * It can fetch random numbers from an external API or generate them locally.
 */
public class RandomNumberGenerator {

  private static final String API_URL_TEMPLATE =
      "https://www.random.org/integers/?num=%d&min=0&max=7&col=1&base=10&format=plain&rnd=new";

  /**
   * Generates a random number of the specified length.
   * It first tries to fetch the number from an external API.
   * If the API call fails, it falls back to local random number generation.
   *
   * @param codeLength The length of the random number to generate
   * @return The generated random number as a string
   */
  public String generateNumber(int codeLength) {
    try {
      String response = fetchRandomNumberFromAPI(codeLength);
      if (response != null) {
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

    return generateLocalRandomNumber(codeLength);
  }

  /**
   * Fetches a random number from an external API.
   *
   * @param codeLength The length of the random number to fetch
   * @return The fetched random number as a string
   * @throws Exception If an error occurs during the API call
   */
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

  /**
   * Reads the response from the API call.
   *
   * @param connection The HTTP connection to the API
   * @return The response as a string
   * @throws Exception If an error occurs while reading the response
   */
  private String readResponse(HttpURLConnection connection) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder response = new StringBuilder();
    String inputLine;

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine).append("\n");
    }
    in.close();
    return response.toString().trim();
  }

  /**
   * Generates a random number locally with the specified length.
   * Each digit of the number is between 0 and 7.
   *
   * @param codeLength The length of the random number to generate
   * @return The generated random number as a string
   */
  public String generateLocalRandomNumber(int codeLength) {
    Random random = new Random();
    StringBuilder localRandomNumber = new StringBuilder();
    for (int i = 0; i < codeLength; i++) {
      localRandomNumber.append(random.nextInt(8));
    }
    return localRandomNumber.toString();
  }
}