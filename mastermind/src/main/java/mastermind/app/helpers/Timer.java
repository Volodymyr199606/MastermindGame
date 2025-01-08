package mastermind.app.helpers;

/**
 * The Timer class provides functionality to measure elapsed time between a start and stop event.
 * It can be used to track the duration of various operations and format the elapsed time for display.
 */
public class Timer {
  private long startTime;
  private long endTime;

  public void start() {
    startTime = System.currentTimeMillis();
  }

  public void stop() {
    endTime = System.currentTimeMillis();
  }

  public long getElapsedTime() {
    return endTime - startTime;
  }

  /**
   * Returns the formatted elapsed time as a string in the format HH:mm:ss.
   *
   * @return The formatted elapsed time.
   */
  public String getFormattedElapsedTime() {
    long elapsedTime = getElapsedTime();
    long seconds = (elapsedTime / 1000) % 60;
    long minutes = (elapsedTime / (1000 * 60)) % 60;
    long hours = (elapsedTime / (1000 * 60 * 60)) % 24;
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
}