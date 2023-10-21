package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;
import static baseball.common.Constant.MAX_BALL_NUMBER;
import static baseball.common.Constant.MIN_BALL_NUMBER;
import static baseball.common.Message.BALL_MESSAGE;
import static baseball.common.Message.EMPTY_MESSAGE;
import static baseball.common.Message.STRIKE_MESSAGE;
import static baseball.common.Message.SUCCESS_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBall {

  private final List<Integer> ballNumbers;

  public BaseBall() {
    this.ballNumbers = generatedRandomBallNumbers();
  }

  public List<Integer> getBallNumbers() {
    return this.ballNumbers;
  }

  public int getStrikeCount(List<Integer> targetBallNumbers) {
    int strikeCount = 0;
    int ballCount = 0;

    for (int i = 0; i < BALL_AMOUNT; i++) {
      Integer ballNumber = this.ballNumbers.get(i);
      Integer targetBallNumber = targetBallNumbers.get(i);

      if (ballNumber.equals(targetBallNumber)) {
        strikeCount++;
        continue;
      }

      if (this.ballNumbers.contains(targetBallNumber)) {
        ballCount++;
      }
    }

    printResult(ballCount, strikeCount);

    return strikeCount;
  }

  public Boolean isSucceed(int strikeCount) {
    if (strikeCount == BALL_AMOUNT) {
      System.out.println(SUCCESS_MESSAGE);
      return true;
    }
    return false;
  }

  private void printResult(int ballCount, int strikeCount) {
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

  private List<Integer> generatedRandomBallNumbers() {
    List<Integer> ballNumbers = new ArrayList<>();

    while (ballNumbers.size() < BALL_AMOUNT) {
      int randomNumber = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
      addBallNumber(ballNumbers, randomNumber);
    }

    return ballNumbers;
  }

  private void addBallNumber(List<Integer> ballNumbers, int randomNumber) {
    if (!ballNumbers.contains(randomNumber)) {
      ballNumbers.add(randomNumber);
    }
  }

}
