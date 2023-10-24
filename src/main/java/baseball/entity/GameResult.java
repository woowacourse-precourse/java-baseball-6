package baseball.entity;

public class GameResult {

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        if (ball != 0) {
            sb.append(ball).append("볼").append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString();
    }

}
