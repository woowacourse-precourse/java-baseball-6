package baseball.view;

import baseball.domain.BallsFactory;
import baseball.domain.Pitching;
import camp.nextstep.edu.missionutils.Console;

public class ApplicationConsole implements ConsoleView {

  private static final String COLON = ": ";
  private static final String NEW_LINE = "\n";
  private static final String STRIKE_RESULT_FORMAT = "%d스트라이크 ";
  private static final String BALL_RESULT_FORMAT = "%d볼 ";
  private static final String NOTING_RESULT_FORMAT = "낫싱";

  @Override
  public void printGameStartMessage() {
    print(Message.GAME_START_PROMPT + NEW_LINE);
  }

  @Override
  public void printGuessResult(Pitching pitching) {
    int ball = pitching.ball();
    int strike = pitching.strike();
    if (ball == 0) {
      if (strike == 0) {
        print(NOTING_RESULT_FORMAT + NEW_LINE);
        return;
      }
      print(String.format(STRIKE_RESULT_FORMAT + NEW_LINE, strike));
      return;
    }
    if (strike == 0) {
      print(String.format(BALL_RESULT_FORMAT + NEW_LINE, ball));
      return;
    }
    print(String.format(BALL_RESULT_FORMAT + STRIKE_RESULT_FORMAT + NEW_LINE, ball, strike));
  }

  @Override
  public void printGameResult() {
    print(String.format(Message.RETURN_GAME_RESULT_FORMAT + Message.GAME_FINISH,
        BallsFactory.DIGIT_COUNT));
  }

  @Override
  public String getUserGuess() {
    print(Message.REQUEST_USER_GUESS + COLON);
    return getUserInput();
  }

  @Override
  public String getUserDecision() {
    print(Message.RESTART_OR_QUIT_PROMPT);
    return getUserInput();
  }


  private String getUserInput() {
    return Console.readLine();
  }

  private void print(String message) {
    System.out.print(message);
  }
}
