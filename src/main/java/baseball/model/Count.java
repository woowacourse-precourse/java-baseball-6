package baseball.model;

public class Count {
    private static int strike;
    private static int ball;

    public static int getStrike() {
        return strike;
    }

    public static int getBall() {
        return ball;
    }

    public static void setStrike(int strike) {
        Count.strike = strike;
    }

    public static void setBall(int ball) {
        Count.ball = ball;
    }
}
