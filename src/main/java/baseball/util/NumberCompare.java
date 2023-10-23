package baseball.util;

public class NumberCompare {
    private int ball, strike;

    public int getStrike() {
        return strike;
    }

    public int[] getNumberCompareResult(String playerNumber, String answerNumber) {
        resetCount();
        ballCount(playerNumber, answerNumber);
        strikeCount(playerNumber, answerNumber);
        strikeExceptBall();

        return new int[]{ball, strike};
    }

    private void resetCount() {
        ball = 0;
        strike = 0;
    }

    private void ballCount(String playerNumber, String answerNumber) {
        //일치하는 갯수카운팅(스트+볼 포함)
        for (int i = 0; i < playerNumber.length(); ++i) {
            if (answerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ball++;
            }
        }
    }

    private void strikeCount(String playerNumber, String answerNumber) {
        //위치까지 일치하면 스트라이크
        for (char playerNum : playerNumber.toCharArray()) {
            if (answerNumber.indexOf(playerNum) == playerNumber.indexOf(playerNum)) {
                strike++;
            }
        }
    }

    private void strikeExceptBall() {
        ball = ball - strike;
    }
}
