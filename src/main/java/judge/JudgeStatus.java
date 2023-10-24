package judge;

public enum JudgeStatus {

    CORRECT, PARTIAL_CORRECT, NOTHING;

    private static final int CORRECT_STRIKE_COUNT = 3;
    private static final int NOTHING_COUNT = 0;

    static JudgeStatus of(int ball, int strike) {
        if (isCorrect(strike)) {
            return JudgeStatus.CORRECT;
        }
        if (isNothing(ball, strike)) {
            return JudgeStatus.NOTHING;
        }
        return JudgeStatus.PARTIAL_CORRECT;
    }

    private static boolean isCorrect(int strike) {
        return strike == CORRECT_STRIKE_COUNT;
    }

    private static boolean isNothing(int ball, int strike) {
        return ball == NOTHING_COUNT && strike == NOTHING_COUNT;
    }
}
