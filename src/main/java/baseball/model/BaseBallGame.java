package baseball.model;

import baseball.util.constants.BaseballGameConstants;
import java.util.Arrays;

public class BaseBallGame {

    private final Computer computer;
    private BallCount currentBallCount;

    private BaseBallGame(Computer computer) {
        this.computer = computer;
        this.currentBallCount = new BallCount(0, 0);
    }

    public static BaseBallGame startGame() {
        return new BaseBallGame(new Computer());
    }

    public BallCount getCurrentBallCount() {
        return this.currentBallCount;
    }

    public boolean isGameWin() {
        return currentBallCount.strike() == BaseballGameConstants.NUM_LENGTH;
    }

    public void inputAnswer(int[] input) {
        if (input == null || input.length != BaseballGameConstants.NUM_LENGTH) {
            throw new IllegalArgumentException();
        }
        currentBallCount = compareNumbers(input, computer.getNumbers());
    }

    private BallCount compareNumbers(int[] input, int[] answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == answer[i]) {
                strike++;
            } else if (containValue(answer, input[i])) {
                ball++;
            }
        }

        return new BallCount(strike, ball);
    }

    private boolean containValue(int[] array, int value) {
        return Arrays.stream(array).anyMatch(x -> x == value);
    }
}
