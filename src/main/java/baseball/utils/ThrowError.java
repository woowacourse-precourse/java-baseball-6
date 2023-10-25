package baseball.utils;

public class ThrowError {

  public static void notValidGuessNumber() {
    throw new IllegalArgumentException(Constants.GUESS_NUMBER_ERROR_MESSAGE);
  }

  public static void notValidExitNumber() {
    throw new IllegalArgumentException(Constants.EXIT_NUMBER_ERROR_MESSAGE);
  }
}
