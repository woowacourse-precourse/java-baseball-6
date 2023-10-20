package baseball.baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBall {

  private static final int MAX_BALL_SIZE = 3;
  private static final int RANGE_FIREST_NUMBER = 1;
  private static final int RANGE_LAST_NUMBER = 9;
  private final List<Integer> ballNumbers;

  public BaseBall() {
    this.ballNumbers = generatedRandomBallNumbers();
  }

  public List<Integer> getBallNumbers() {
    return this.ballNumbers;
  }

  private List<Integer> generatedRandomBallNumbers() {
    List<Integer> ballNumbers = new ArrayList<>();

    while (ballNumbers.size() < MAX_BALL_SIZE) {
      int randomNumber = Randoms.pickNumberInRange(RANGE_FIREST_NUMBER, RANGE_LAST_NUMBER);
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
