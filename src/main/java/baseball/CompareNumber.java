package baseball;

public class CompareNumber {
    private int ball;
    private int strike;

    public int getStrike() {
        return strike;
    }

    public int[] compareResult(String computerNumber, String playerNumber) {
        resetCount();
        ballCount(computerNumber, playerNumber);
        strikeCount(computerNumber, playerNumber);
        strikeExceptBall();

        return new int[]{ball, strike};

    }

    public void resetCount() {
        ball = 0;
        strike = 0;

    }

    public void ballCount(String computerNumber, String playerNumber) {
        for (int i = 0; i < playerNumber.length(); i++) {
            char digit = playerNumber.charAt(i);
            if (computerNumber.contains(Character.toString(digit))) {
                ball++;
            }
        }
    }

    public void strikeCount(String computerNumber, String playerNumber) {
        for (char playerNum : playerNumber.toCharArray()) {
            if (computerNumber.indexOf(playerNum) == playerNumber.indexOf(playerNum)) {
                strike++;
            }
        }
    }

    public void strikeExceptBall() {

        ball = ball - strike;
    }
}
