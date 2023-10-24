package baseball;
public class BaseballResultState {
    public int ball;
    public int strike;

    BaseballResultState(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isGameOver() {
        return strike == 3;
    }

    public String toString() {
        if (ball == 0 && strike == 0)
            return "낫싱";
        if (ball != 0 && strike == 0)
            return String.format("%d볼", ball);
        if (ball == 0 && strike != 0)
            return String.format("%d스트라이크", strike);
        return String.format("%d볼 %d스트라이크", ball, strike);
    }
}
