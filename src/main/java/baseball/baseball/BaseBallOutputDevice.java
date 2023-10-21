package baseball.baseball;

import static baseball.common.Message.BALL_MESSAGE;
import static baseball.common.Message.EMPTY_MESSAGE;
import static baseball.common.Message.END_INPUT_MESSAGE;
import static baseball.common.Message.START_INPUT_MESSAGE;
import static baseball.common.Message.STRIKE_MESSAGE;
import static baseball.common.Message.SUCCESS_MESSAGE;

public class BaseBallOutputDevice {

  public void printResultMessage(Result result) {
    int strikeCount = result.getStrikeCount();
    int ballCount = result.getBallCount();

    if (ballCount == 0 && strikeCount == 0) {
      System.out.println(EMPTY_MESSAGE);
    } else if (ballCount == 0) {
      System.out.println(strikeCount + STRIKE_MESSAGE);
    } else if (strikeCount == 0) {
      System.out.println(ballCount + BALL_MESSAGE);
    } else {
      System.out.println(ballCount + BALL_MESSAGE + " " + strikeCount + STRIKE_MESSAGE);
    }
  }

  public void printSuccessMessage() {
    System.out.println(SUCCESS_MESSAGE);
  }

  public void printStartInputMessage() {
    System.out.print(START_INPUT_MESSAGE);
  }

  public void printEndInputMessage() {
    System.out.println(END_INPUT_MESSAGE);
  }

}
