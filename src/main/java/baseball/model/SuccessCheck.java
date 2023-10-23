package baseball.model;

public class SuccessCheck {
    private final CompareNumber compareNumber;

    public SuccessCheck() {
        compareNumber = new CompareNumber();
    }

    public int[] CheckOfSuccess(String computerNumber, String playerNumber) {
        return compareNumber.getStrikeAndBall(computerNumber, playerNumber);
    }

    public boolean isSuccess() {
        return compareNumber.isStrike() == 3;
    }
}
