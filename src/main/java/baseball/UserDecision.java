package baseball;

import static baseball.View.displayRestartMessage;

import camp.nextstep.edu.missionutils.Console;

public class UserDecision {

  /**
   * Displays Restart Message. Returns user input, after checking it is valid.
   *
   * @return the user input
   */
  public static String getUserDecision() {
    displayRestartMessage();
    String input = Console.readLine();
    checkUserDecision(input);
    return input;
  }

  /**
   * Checks if user input is valid. Throws IllegalArgumentException and ends program if input is not
   * valid.
   *
   * @param input the user input
   */
  private static void checkUserDecision(String input) throws IllegalArgumentException {
    if (!(input.equals("1") || input.equals("2"))) {
      throw new IllegalArgumentException();
    }
  }

}
