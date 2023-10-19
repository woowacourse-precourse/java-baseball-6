package baseball;

import static baseball.GameClient.BALL_LENGTH;

/**
 * 스트라이크, 볼 개수를 저장하는 클래스.
 */
public class BallCount {

    private int strike;
    private int ball;

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public boolean isOut() {
        return this.strike == BALL_LENGTH;
    }
}
