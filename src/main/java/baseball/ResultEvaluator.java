package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ResultEvaluator {

  private static final int FULL_CORRECT_COUNT = 3;

  public static boolean evaluate(Baseball value) {
    int strike = value.strike();
    int ball = value.ball();

    if (strike == FULL_CORRECT_COUNT) {
      Printer.correct();
      return true;
    } else if (strike == 0 && ball == 0) {
      Printer.nothing();
    } else if (strike != 0 && ball == 0) {
      Printer.strike(strike);
    } else if (strike == 0 && ball != 0) {
      Printer.ball(ball);
    } else {
      Printer.other(ball, strike);
    }

    return false;
  }

  public static boolean restart() {
    Printer.exitOption();
    int exitOption = Integer.parseInt(Console.readLine());

    return exitOption == 1;
  }
}
