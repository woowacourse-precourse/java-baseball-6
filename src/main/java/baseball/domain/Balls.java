package baseball.domain;

import baseball.view.Message;
import java.util.ArrayList;
import java.util.List;

/*
  숫자 저장과 반환 등의 로직을 담은 클래스
 */
public class Balls {

  private final List<Integer> balls;

  // 컴퓨터가 생성 시 호출
  public Balls(List<Integer> balls) {
    this.balls = balls;
  }

  // 사용자가 입력 시 호출
  public Balls(String balls) {
    validate(balls);
    this.balls = splitBalls(balls);
  }

  public boolean contains(int ball) {
    return this.balls.contains(ball);
  }

  public int getBall(int index) {
    return this.balls.get(index);
  }

  private void validate(String balls) {
    // 중복 없는 세 자리 숫자 입력했는지 확인
    if (balls.length() != BallsFactory.DIGIT_COUNT) {
      throw new IllegalArgumentException(Message.INVALID_DIGIT_COUNT);
    }
    // 입력 값이 1 ~ 9 사이의 숫자들인지 확인
    if (!balls.matches(BallsFactory.INPUT_NUMBER_REGEX)) {
      throw new IllegalArgumentException(Message.OUT_OF_RANGE);
    }
  }

  private List<Integer> splitBalls(String balls) {
    List<Integer> newBalls = new ArrayList<>();
    for (int i = 0; i < BallsFactory.DIGIT_COUNT; i++) {
      String ball = String.valueOf(balls.charAt(i));
      newBalls.add(Integer.parseInt(ball));
    }
    return newBalls;
  }
}
