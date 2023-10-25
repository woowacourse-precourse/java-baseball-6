package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class BallsFactory {

  public static final int DIGIT_COUNT = 3;
  public static final String INPUT_NUMBER_REGEX = "^[1-9]+$";
  private static final int MIN_VALUE = 1;
  private static final int MAX_VALUE = 9;

  public static Balls create() {
    List<Integer> balls = new ArrayList<>();
    while (balls.size() < DIGIT_COUNT) {
      int ball = getRandomNumber();
      if (!balls.contains(ball)) {
        balls.add(ball);
      }
    }
    return new Balls(balls);
  }

  private static int getRandomNumber() {
    return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
  }
}
