package baseball.baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBall {

  private static final int MAX_BALL_SIZE = 3;
  private static final int RANGE_FIRST_NUMBER = 1;
  private static final int RANGE_LAST_NUMBER = 9;
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

    for (int i = 0; i < MAX_BALL_SIZE; i++) {
      Integer ballNumber = this.ballNumbers.get(i);
      Integer targetBallNumber = targetBallNumbers.get(i);

      if (ballNumber.equals(targetBallNumber)) { // 스트라이크 인경우
        strikeCount++;
        continue;
      }

      if (this.ballNumbers.contains(targetBallNumber)) { // 볼 인경우
        ballCount++;
      }
    }

    printResult(ballCount, strikeCount);

    return strikeCount;
  }

  private void printResult(int ballCount, int strikeCount) {
    if (ballCount == 0 && strikeCount == 0) {
      System.out.println("낫싱");
    } else if (ballCount == 0) {
      System.out.println(strikeCount + "스트라이크");
    } else if (strikeCount == 0) {
      System.out.println(ballCount + "볼");
    } else {
      System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
  }

  private List<Integer> generatedRandomBallNumbers() {
    List<Integer> ballNumbers = new ArrayList<>();

    while (ballNumbers.size() < MAX_BALL_SIZE) {
      int randomNumber = Randoms.pickNumberInRange(RANGE_FIRST_NUMBER, RANGE_LAST_NUMBER);
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
