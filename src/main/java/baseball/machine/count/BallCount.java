package baseball.machine.count;

// BallCount는 야구에서 흔히 쓰이는 용어로, Ball, Strike 를 세는데 사용함
public class BallCount {

    private int ball;
    private int strike;

    public void addBall() {
        this.ball++;
    }
    public void addStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
