package baseball.domain;


import static baseball.util.MagicNumber.MAX_SIZE;
import static baseball.util.MagicNumber.MIN_SIZE;

public class GameResult {

    private int strike;
    private int ball;

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
        if(number > MAX_SIZE.getNumber() || number < MIN_SIZE.getNumber()) {
            throw new IllegalArgumentException("스트라이크 또는 볼은 0~3 사이입니다.");
        }
    }
}
