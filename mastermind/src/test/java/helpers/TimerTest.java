package helpers;

import mastermind.app.helpers.Timer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimerTest {

  @Test
  void testElapsedTime() throws InterruptedException {
    Timer timer = new Timer();
    timer.start();
    Thread.sleep(1000);
    timer.stop();
    long elapsedTime = timer.getElapsedTime();
    assertTrue(elapsedTime >= 1000 && elapsedTime < 1100, "Elapsed time should be around 1000 milliseconds");
  }

  @Test
  void testFormattedElapsedTime() throws InterruptedException {
    Timer timer = new Timer();
    timer.start();
    Thread.sleep(1000);
    timer.stop();
    String formattedTime = timer.getFormattedElapsedTime();
    assertEquals("00:00:01", formattedTime, "Formatted time should be 00:00:01");
  }
}