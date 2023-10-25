package baseball.domain;

public class Ball {
    private int ball;

    public Ball(int ball) {
        this.ball = ball;
    }

    public int getCount() {
        return ball;
    }

    public void increase() {
        ball++;
    }
}
