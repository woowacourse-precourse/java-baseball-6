package baseball;

import static baseball.View.displayRestartMessage;

import camp.nextstep.edu.missionutils.Console;

public class UserDecision {

  public static String getUserDecision() {
    displayRestartMessage();
    String input = Console.readLine();
    checkUserDecision(input);
    return input;
  }

  private static void checkUserDecision(String input) throws IllegalArgumentException {
    if (!(input.equals("1") || input.equals("2"))) {
      throw new IllegalArgumentException();
    }
  }

}
