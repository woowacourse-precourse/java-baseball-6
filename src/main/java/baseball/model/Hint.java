package baseball.model;

public class Hint {
    private final GameNumber gameNumber;
    private final InputNumbers inputNumbers;
    private static final int INPUT_LENGTH = 3;

    public Hint(GameNumber gameNumber, InputNumbers inputNumbers) {
        this.gameNumber = gameNumber;
        this.inputNumbers = inputNumbers;
    }

    public int countStrikes() {
        int strikes = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (isStrike(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private boolean isStrike(int index) {
        return gameNumber.getNumber(index) == inputNumbers.getNumber(index);
    }

    public int countBalls() {
        int balls = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (isBall(i)) {
                balls++;
            }
        }
        return balls;
    }
    
    private boolean isBall(int index) {
        int number = gameNumber.getNumber(index);

        for (int j = 0; j < INPUT_LENGTH; j++) {
            if (index != j && number == inputNumbers.getNumber(j)) {
                return true;
            }
        }
        return false;
    }
}
