package baseball.model;

public class Result {
    private static int strike = 0;
    private static int ball = 0;

    public static void countStrike() {
        strike++;
    }

    public static void countball() {
        ball++;
    }

    public static void reset() {
        strike = 0;
        ball = 0;
    }

    public static int getStrike() {
        return strike;
    }

    public static int getBall() {
        return ball;
    }
}
