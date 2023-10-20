package baseball;

import static baseball.Input.NUMBER_LENGTH;

public class Judge {

    private static final int CORRECT_STRIKE_COUNT = 3;
    private static final int NOTHING_COUNT = 0;

    private final String computerNumber;
    private String userNumber;

    private int ball;
    private int strike;

    public Judge(final String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public JudgeResult of(final String userNumber) {
        init(userNumber);
        count();
        return new JudgeResult(ball, strike, getStatus());
    }

    private void init(final String userNumber) {
        this.userNumber = userNumber;
        this.ball = 0;
        this.strike = 0;
    }

    private void count() {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            addIfBall(i);
            addIfStrike(i);
        }
    }

    private JudgeStatus getStatus() {
        if (isCorrect()) {
            return JudgeStatus.CORRECT;
        }
        if (isNothing()) {
            return JudgeStatus.NOTHING;
        }
        return JudgeStatus.INCORRECT;
    }

    private void addIfBall(int i) {
        for (int j = 0; j < NUMBER_LENGTH; j++) {
            if (isBall(i, j)) {
                ball++;
            }
        }
    }

    private void addIfStrike(int i) {
        if (isStrike(i)) {
            strike++;
        }
    }

    private boolean isBall(int i, int j) {
        return i != j && computerNumber.charAt(i) == userNumber.charAt(j);
    }

    private boolean isStrike(int i) {
        return computerNumber.charAt(i) == userNumber.charAt(i);
    }

    private boolean isCorrect() {
        return strike == CORRECT_STRIKE_COUNT;
    }

    private boolean isNothing() {
        return ball == NOTHING_COUNT && strike == NOTHING_COUNT;
    }
}
