package baseball.model;

public class SuccessCheck {
    private final Compare compare;

    public SuccessCheck() {
        compare = new Compare();
    }

    public int[] CheckOfSuccess(String computerNumber, String playerNumber) {
        return compare.getStrikeAndBall(computerNumber, playerNumber);
    }

    public boolean isSuccess() {
        return compare.isStrike() == 3;
    }
}
