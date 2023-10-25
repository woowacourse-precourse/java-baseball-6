package baseball;

import static baseball.Application.MAX_NUMBER_SIZE;

public class CalculateResult {
    private final ComputerNumber computerNumber;
    private final PlayerNumber playerNumber;
    private int strike = 0;
    private int ball = 0;
    public CalculateResult(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
        calculateStrike();
        calculateBall();
    }
    private void calculateStrike() {
        for (int index = 0; index< MAX_NUMBER_SIZE; index++) {
            strike += countStrikeByIndex(index);
        }
    }
    private int countStrikeByIndex(int index) {
        int playerNumber = this.playerNumber.getNumber(index);
        if (computerNumber.isEqualNumberSameIndex(playerNumber, index)) {
            return 1;
        }
        return 0;
    }
    private void calculateBall() {
        for (int index = 0; index< MAX_NUMBER_SIZE; index++) {
            ball += checkBallByIndex(index);
        }
        ball -= strike;
    }
    private int checkBallByIndex(int index) {
        int playerNumber = this.playerNumber.getNumber(index);
        if (computerNumber.containsNumber(playerNumber)) {
            return 1;
        }
        return 0;
    }
    public int[] getResult() {
        return new int[]{strike, ball};
    }
}
