package baseball.domain;

public class GameResult {

    private int strike;
    private int ball;

    public boolean verifyEnd() {
        return this.strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        validateStrikeBall(strike);
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        validateStrikeBall(ball);
        this.ball = ball;
    }

    public void validateStrikeBall(int number) {
        if(number > 3 || number < 0) {
            throw new IllegalArgumentException("스트라이크 또는 볼은 0~3 사이입니다.");
        }
    }
}
