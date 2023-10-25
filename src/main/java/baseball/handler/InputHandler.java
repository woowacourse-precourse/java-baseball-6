package baseball.handler;

import baseball.utils.Convertor;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

  /**
   * Input Operator : Player Guess Number
   */
  public static int[] inputGuessNumbers() {
    String inputNumber = Console.readLine();
    ValidateHandler.isValidGuessNumber(inputNumber);
    return Convertor.convertStringToIntArray(inputNumber);
  }

  /**
   * Input Operator : Exit Number
   */
  public static String inputExitNumbers() {
    String inputNumber = Console.readLine();
    ValidateHandler.isValidExitNumber(inputNumber);
    return inputNumber;
  }
}

