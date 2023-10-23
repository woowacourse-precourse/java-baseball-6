package baseball.domain;

import java.util.List;


public class BallCount {
    private static int strike;
    private static int ball;

    public static boolean isStrike(List<Integer> generatedAnswer, List<Integer> submittedAnswer) {
        return generatedAnswer.equals(submittedAnswer);
    }
    public static void plusStrike() {
        strike++;
    }

    public static boolean isBall(List<Integer> generatedAnswer, List<Integer> submittedAnswer) {
        return !isStrike(generatedAnswer, submittedAnswer) && generatedAnswer.contains(submittedAnswer);
    }
    public static void plusBall() {
        ball++;
    }

    public boolean isAllStrike(int strike) {
        return strike == 3;
    }
    public boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
}
