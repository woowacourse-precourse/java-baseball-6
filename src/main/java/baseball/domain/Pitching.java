package baseball.domain;

public class Pitching {
    int[] inputNumber;

    Pitching(Ball ball) {
        int input = ball.getInputNumber();
        this.inputNumber = ball.getDigitsArray(input);
    }
}
