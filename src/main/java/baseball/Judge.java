package baseball;

import java.util.List;

import static baseball.Input.NUMBER_LENGTH;

public class Judge {

    private static final int CORRECT_STRIKE_COUNT = 3;
    private static final int NOTHING_COUNT = 0;

    private final String computer;
    private String userNumber;

    private int ball;
    private int strike;

    public Judge(final String computer) {
        this.computer = computer;
    }

    public JudgeStatus of(final String guess) {
        init(guess);
        count();
        return getStatus();
    }

    private void init(final String guess) {
        this.userNumber = guess;
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
        return i != j && computer.charAt(i) == userNumber.charAt(j);
    }

    private boolean isStrike(int i) {
        return computer.charAt(i) == userNumber.charAt(i);
    }

    private boolean isCorrect() {
        return strike == CORRECT_STRIKE_COUNT;
    }

    private boolean isNothing() {
        return ball == NOTHING_COUNT && strike == NOTHING_COUNT;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
