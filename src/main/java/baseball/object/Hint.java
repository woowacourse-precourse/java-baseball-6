package baseball.object;

public class Hint {

    private static int ball;
    private static int strike;

    public Hint() {
        ball = 0;
        strike = 0;
    }

    public static int getBall() {
        return ball;
    }

    public static int getStrike() {
        return strike;
    }

    public static boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public static boolean isThreeStrike() {
        return strike == 3;
    }

    public static boolean isBallZero() {
        return ball == 0;
    }

    public static boolean isStrikeZero() {
        return strike == 0;
    }

    public static void increaseStrike() {
        strike++;
    }

    public static void increaseBall() {
        ball++;
    }
}
