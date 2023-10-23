package baseball.model;

public class BaseBallGame {
    private final BaseBallNumber computerNumber;
    public BaseBallGame(int digit) {
        computerNumber = BaseBallNumber.generateRandomNumbers(digit);
    }


}
