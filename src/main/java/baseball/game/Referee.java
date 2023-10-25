package baseball.game;

import baseball.domain.Balls;
import baseball.domain.BallsFactory;
import baseball.domain.Pitching;

/*
  비교 연산과 결과 반환을 담당하는 클래스
 */
public class Referee {

  private int ball;
  private int strike;
  public final Balls answerBalls;

  public Referee(Balls answerBalls) {
    this.answerBalls = answerBalls;
  }

  public void resetCount() {
    this.ball = 0;
    this.strike = 0;
  }

  public Pitching matches(Balls userBalls) {

    for (int index = 0; index < BallsFactory.DIGIT_COUNT; index++) {
      int userBall = userBalls.getBall(index);
      if (answerBalls.contains(userBall)) { // 유저의 한 숫자가 정답에 포함되어 있다면
        checkBallOrStrike(userBall, index);
      }
    }
    return new Pitching(this.ball, this.strike);
  }

  private void checkBallOrStrike(int userBall, int index) {

    if (this.answerBalls.getBall(index) == userBall) {
      plusStrikeCount();
      return;
    }
    plusBallCount();
  }

  private void plusBallCount() {
    this.ball++;
  }

  private void plusStrikeCount() {
    this.strike++;
  }

  public boolean isStrikeOut() {
    return this.strike == BallsFactory.DIGIT_COUNT;
  }
}
