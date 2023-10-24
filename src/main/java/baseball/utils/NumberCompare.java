package baseball.utils;

public class NumberCompare {
    private final int INPUT_RANGE = 3;
    private int ball;
    private int strike;

    public int getStrike() {
        return strike;
    }


    public void resetCount() {
        ball = 0;
        strike = 0;
    }

    public void ballCount(String playerNumber, String computerNumber) {
        for (int i = 0; i < INPUT_RANGE; i++) {
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ball++;
            }
        }
    }

    public void strikeCount(String playerNumber, String computerNumber) {
        for (int i = 0; i < INPUT_RANGE; i++) {
            if (computerNumber.charAt(i) == playerNumber.charAt(i)) {
                strike++;
            }
        }
    }

    public void strikeException() {
        ball = ball - strike;
    }

    public int[] getCompareNumber(String playerNumber, String computerNumber) {
        resetCount();
        ballCount(playerNumber, computerNumber);
        strikeCount(playerNumber, computerNumber);
        strikeException();
        return new int[]{ball, strike};
    }
}
