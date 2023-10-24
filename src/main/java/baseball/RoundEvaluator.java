package baseball;

public class RoundEvaluator {
    public static int calculateStrikeCount(ThreeBalls targetBalls, ThreeBalls userBalls) {
        return targetBalls.equalsCount(userBalls);
    }

    public static int calculateBallCount(ThreeBalls targetBalls, ThreeBalls userBalls, int strikeCount) {
        int containCount = targetBalls.containCount(userBalls);

        return containCount - strikeCount;
    }
}
