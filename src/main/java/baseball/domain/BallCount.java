package baseball.domain;

public class BallCount {
    private final int ball;
    private final int strike;

    public BallCount(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public String comment() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.ball > 0) {
            stringBuilder.append(this.ball).append("볼 ");
        }
        if (this.strike > 0) {
            stringBuilder.append(this.strike).append("스트라이크 ");
        }

        String commentary = stringBuilder.toString();
        if (!commentary.isEmpty()) {
            return commentary;
        }
        return "낫싱";
    }

    public boolean gameEnd() {
        return this.strike == 3;
    }
}
