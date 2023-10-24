package baseball;

import static baseball.ComputerBalls.getComputerBalls;
import static baseball.GameMessageUtil.generateResultMessage;
import static baseball.NumberBaseballRule.countBall;
import static baseball.NumberBaseballRule.countStrike;
import static baseball.UserBalls.getUserInputBalls;
import static baseball.UserDecision.getUserDecision;
import static baseball.View.displayEndMessage;

public class NumberBaseballGame {

  private static final String ROUND_OVER_MESSAGE = "3스트라이크";
  private static final String RESTART_GAME_DECISION = "1";
  private static final String END_GAME_DECISION = "2";

  /**
   * Play rounds while user decision is 1 End Game when user decision is 2.
   */
  public static void playGame() {
    String userDecision;
    do {
      playRound();
      userDecision = getUserDecision();
    } while (userDecision.equals(RESTART_GAME_DECISION));
    if (userDecision.equals(END_GAME_DECISION)) {
      return;
    }
  }

  /**
   * Continue playing rounds until computed result message equals ROUND_OVER_MESSAGE.
   */
  public static void playRound() {
    String computerBalls = getComputerBalls();
    String message;

    do {
      String userBalls = getUserInputBalls();
      message = computeResultMessage(userBalls, computerBalls);
      System.out.println(message);
    }
    while (!message.equals(ROUND_OVER_MESSAGE));
    displayEndMessage();
  }

  /**
   * Returns messages based on calculated strike, balls based on userBalls, computerBalls. ex. "1볼
   * 1스트라이크"
   *
   * @param userBalls
   * @param computerBalls
   * @return the result message
   */
  public static String computeResultMessage(String userBalls, String computerBalls) {
    int strike = countStrike(userBalls, computerBalls);
    int ball = countBall(userBalls, computerBalls);
    return generateResultMessage(strike, ball);
  }

}
