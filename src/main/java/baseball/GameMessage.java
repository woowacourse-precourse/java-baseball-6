package baseball;


public enum GameMessage {
  NOTHING("낫싱"),
  BALL("볼"),
  STRIKE("스트라이크");

  private final String message;

  GameMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public static String generateResultMessage(int strike, int ball) {

    if (isNothing(strike, ball)) {
      return NOTHING.getMessage();
    }
    if (isOnlyBall(strike)) {
      return formatBallMessage(ball);
    }
    if (isOnlyStrike(ball)) {
      return formatStrikeMessage(strike);
    }
    return formatBallAndStrikeMessage(ball, strike);

  }

  private static boolean isNothing(int strike, int ball) {
    return strike == 0 && ball == 0;
  }

  private static boolean isOnlyBall(int strike) {
    return strike == 0;
  }

  private static boolean isOnlyStrike(int ball) {
    return ball == 0;
  }

  private static String formatBallMessage(int ball) {
    return ball + BALL.getMessage();
  }

  private static String formatStrikeMessage(int strike) {
    return strike + STRIKE.getMessage();
  }

  private static String formatBallAndStrikeMessage(int ball, int strike) {
    return ball + BALL.getMessage() + " " + strike + STRIKE.getMessage();
  }


}
