package baseball.handler;

import baseball.utils.Constants;
import baseball.utils.ThrowError;
import java.util.regex.Pattern;

public class ValidateHandler {

  /**
   * Validator : Player Guess Number
   *
   * @param guessNumber
   */
  public static void isValidGuessNumber(String guessNumber) {
    Pattern pattern = Pattern.compile(Constants.GUESS_NUMBER_REGEX);
    if (!pattern.matcher(guessNumber).matches()) {
      ThrowError.notValidGuessNumber();
    }
  }

  /**
   * Validator : Exit Number
   *
   * @param exitNumber
   */
  public static void isValidExitNumber(String exitNumber) {
    if (!exitNumber.equals(Constants.GAME_RESTART) && !exitNumber.equals(
        Constants.GAME_END)) {
      ThrowError.notValidExitNumber();
    }
  }
}
