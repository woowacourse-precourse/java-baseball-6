package baseball.model;

public class CompareNumber {
    private int strike;
    private int ball;
    private int count;

    public int[] getStrikeAndBall(String computerNumber, String playerNumber) {
        strike = 0;
        ball = 0;
        count = 0;
        countAll(computerNumber, playerNumber);
        countStrike(computerNumber, playerNumber);
        countBall(computerNumber, playerNumber);

        return new int[]{ball, strike};
    }

    public boolean isStrike() {
        return strike == 3;
    }

    public void countAll(String computerNumber, String playerNumber) {
        for (int i = 0; i < computerNumber.length(); i++) {
            if (playerNumber.contains(Character.toString(computerNumber.charAt(i)))) {
                count++;
            }
        }
    }

    public void countStrike(String computerNumber, String playerNumber) {
        for (int i = 0; i < computerNumber.length(); i++) {
            if (Character.toString(computerNumber.charAt(i)).equals(Character.toString(playerNumber.charAt(i)))) {
                strike++;
            }
        }
    }

    public void countBall(String computerNumber, String playerNumber) {
        ball = count - strike;
    }
}

