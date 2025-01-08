package mastermind.app.helpers;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
    HttpResponse<String> response;
    try {
      HttpClient client = HttpClient.newHttpClient();
      String apiUrl = String.format(API_URL_TEMPLATE, codeLength);
      URI uri = new URI(apiUrl);
      HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

      response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == HttpURLConnection.HTTP_OK) {
        return response.body().replaceAll("\n", "");
      } else {
        System.out.println("GET request failed. Response Code: " + response.statusCode());
        return null;
      }
    } catch (Exception e) {
      throw new Error("Error fetching random number from API: " + e.getMessage());
    }
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