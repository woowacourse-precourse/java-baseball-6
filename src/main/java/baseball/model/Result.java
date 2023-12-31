package baseball.model;

public class Result {

    private final int strike;
    private final int ball;

    public Result(Ball answer, Ball player) {
        strike = answer.checkStrike(player);
        ball = answer.checkBall(player);
    }


    public boolean isStrikeOut() {
        return strike == 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼").append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        return sb.toString();
    }
}
