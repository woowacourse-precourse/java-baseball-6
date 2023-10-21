package baseball.model;

public class Compare {
    private int strike;
    private int ball;

    public int[] getStrikeAndBall(String computerNumber, String playerNumber) {
        countAll(computerNumber, playerNumber);
        countStrike(computerNumber, playerNumber);
        countBall(computerNumber, playerNumber);

        return new int[]{ball, strike};
    }

    public int isStrike() {
        return strike;
    }

    public int countAll(String computerNumber, String playerNumber) {
        int count = 0;
        for (int i = 0; i < computerNumber.length(); i++) {
            if (playerNumber.contains(Character.toString(computerNumber.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

    public void countStrike(String computerNumber, String playerNumber) {
        strike = 0;
        for (int i = 0; i < computerNumber.length(); i++) {
            if (Character.toString(computerNumber.charAt(i)).equals(Character.toString(playerNumber.charAt(i)))) {
                strike++;
            }
        }
    }

    public void countBall(String computerNumber, String playerNumber) {
        ball = 0;
        ball = countAll(computerNumber, playerNumber) - strike;
    }
}

