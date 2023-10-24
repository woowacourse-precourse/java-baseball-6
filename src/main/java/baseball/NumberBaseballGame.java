package baseball;

import static baseball.ComputerBalls.getComputerBalls;
import static baseball.GameMessage.generateResultMessage;
import static baseball.NumberBaseballRule.countBall;
import static baseball.NumberBaseballRule.countStrike;
import static baseball.UserBalls.getUserInputBalls;
import static baseball.UserDecision.getUserDecision;
import static baseball.View.displayEndMessage;

public class NumberBaseballGame {

  private static final String ROUND_OVER_MESSAGE = "3스트라이크";
  private static final String RESTART_GAME_DECISION = "1";

  public static void playGame() {
    do {
      playRound();
    } while (getUserDecision().equals(RESTART_GAME_DECISION));
  }

  public static void playRound() {
    String computerBalls = getComputerBalls();
    String message = "";

    do {
      String userBalls = getUserInputBalls();
      message = computeResultMessage(userBalls, computerBalls);
      System.out.println(message);
    }
    while (!message.equals(ROUND_OVER_MESSAGE));
    displayEndMessage();
  }

  public static String computeResultMessage(String userBalls, String computerBalls) {
    int strike = countStrike(userBalls, computerBalls);
    int ball = countBall(userBalls, computerBalls);
    return generateResultMessage(strike, ball);
  }

}
