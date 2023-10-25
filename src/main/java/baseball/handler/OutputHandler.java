package baseball.handler;

import baseball.utils.Constants;

public class OutputHandler {

  public static void printGameStartMessage() {
    System.out.println(Constants.GAME_START_MESSAGE);
  }

  public static void printGameEndMessage() {
    System.out.println(Constants.GAME_END_MESSAGE);
    System.out.println(Constants.GAME_RESTART_OR_END_MESSAGE);
  }

  public static void printNumberInputMessage() {
    System.out.print(Constants.NUMBER_INPUT_MESSAGE);
  }

  public static void printGuessNumberResult(int strike, int ball) {
    StringBuilder resultMessage = new StringBuilder();
    if (ball > 0) {
      resultMessage.append(ball).append(Constants.BALL);
    }
    if (strike > 0) {
      resultMessage.append(strike).append(Constants.STRIKE);
    }
    if (ball == 0 && strike == 0) {
      resultMessage.append(Constants.NOTHING);
    }
    System.out.println(resultMessage.toString());
  }
}
