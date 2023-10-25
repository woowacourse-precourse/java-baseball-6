package baseball.model;

public class Hint {
    private static final int THREE_STRIKES = 3;

    private Integer strike;
    private Integer ball;

    public Hint(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Hint from(Integer strike, Integer ball) {
        return new Hint(strike, ball);
    }

    public String generateHintMessage() {
        if (strike != 0 && ball != 0) {
            return String.format("%d볼 %d스트라이크", ball, strike);
        }
        if (strike != 0) {
            return String.format("%d스트라이크", strike);
        }
        if (ball != 0) {
            return String.format("%d볼", ball);
        }
        return "낫싱";
    }

    public boolean isThreeStrike() {
        return strike.equals(THREE_STRIKES);
    }
}
