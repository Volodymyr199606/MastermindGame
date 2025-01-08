package service;
import mastermind.app.service.Feedback;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class FeedbackTest {

  @Test
  public void testCalculateFeedback_AllCorrect() {
    char[] secretCode = {'A', 'B', 'C', 'D'};
    char[] guess = {'A', 'B', 'C', 'D'};
    int[] expected = {4, 4};
    int[] actual = Feedback.calculateFeedback(secretCode, guess, 4);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testCalculateFeedback_SomeCorrect() {
    char[] secretCode = {'A', 'B', 'C', 'D'};
    char[] guess = {'A', 'C', 'B', 'D'};
    int[] expected = {2, 4};
    int[] actual = Feedback.calculateFeedback(secretCode, guess, 4);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testCalculateFeedback_NoneCorrect() {
    char[] secretCode = {'A', 'B', 'C', 'D'};
    char[] guess = {'E', 'F', 'G', 'H'};
    int[] expected = {0, 0};
    int[] actual = Feedback.calculateFeedback(secretCode, guess, 4);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testCalculateFeedback_PartialCorrect() {
    char[] secretCode = {'A', 'B', 'C', 'D'};
    char[] guess = {'A', 'E', 'C', 'F'};
    int[] expected = {2, 2};
    int[] actual = Feedback.calculateFeedback(secretCode, guess, 4);
    assertArrayEquals(expected, actual);
  }
}