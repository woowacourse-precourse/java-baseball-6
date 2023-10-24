package baseball;

public class BaseballCount {
    private final int strike;
    private final int ball;

    public BaseballCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getResultBriefing() {
        StringBuilder stringBuilder = new StringBuilder();
        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫싱");
        } else if (strike > 0 || ball > 0) {
            if (ball != 0) {
                stringBuilder.append(ball).append("볼 ");
            }
            if (strike != 0) {
                stringBuilder.append(strike).append("스트라이크");
            }
        }
        return stringBuilder.toString().trim();
    }

    public boolean isAllStrike() {
        return strike == 3;
    }
}
