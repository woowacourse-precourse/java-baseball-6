package baseball;

public class Baseball {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int ballNumber;

    public Baseball(int ballNumber) {
        validateBallNumber(ballNumber);
        this.ballNumber = ballNumber;
    }

    private void validateBallNumber(int ballNumber) {
        if (ballNumber < MIN_NUMBER || ballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위가 유효하지 않습니다.(1-9까지의 숫자만 입력 가능합니다.)");
        }
    }

}
