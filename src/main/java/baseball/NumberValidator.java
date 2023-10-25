package baseball;

public class NumberValidator {
    private int ballNum;
    private int strikeNum;

    public int getStrikeNum() {
        return strikeNum;
    }

    public int[] compareResult(String computerNumber, String playerNumber) {
        resetCount();
        ballCount(computerNumber, playerNumber);
        strikeCount(computerNumber, playerNumber);
        strikeExceptBall();

        return new int[]{ballNum, strikeNum};

    }

    public void resetCount() {
        ballNum = 0;
        strikeNum = 0;

    }

    public void ballCount(String computerNumber, String playerNumber) {
        for (int i = 0; i < playerNumber.length(); i++) {
            char digit = playerNumber.charAt(i);
            if (computerNumber.contains(Character.toString(digit))) {
                ballNum++;
            }
        }
    }

    public void strikeCount(String computerNumber, String playerNumber) {
        for (char playerNum : playerNumber.toCharArray()) {
            if (computerNumber.indexOf(playerNum) == playerNumber.indexOf(playerNum)) {
                strikeNum++;
            }
        }
    }

    public void strikeExceptBall() {

        ballNum = ballNum - strikeNum;
    }
}
