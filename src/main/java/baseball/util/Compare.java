package baseball.util;

public class Compare {

    private int strikeCnt;
    private int ballCnt;

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int[] getStrikeBallCnt(String playerNumber, String computerNumber) {
        resetCnt();
        upBallCnt(playerNumber, computerNumber);
        upStrikeCnt(playerNumber, computerNumber);
        ballAfterStrike();
        return new int[] {ballCnt, strikeCnt};
    }

    private void resetCnt() {
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    private void upBallCnt(String playerNumber, String computerNumber) {
        for (int i = 0; i < playerNumber.length(); i++) {
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ballCnt++;
            }
        }
    }

    private void upStrikeCnt(String playerNumber, String computerNumber) {
        for (char player : playerNumber.toCharArray()) {
            if(playerNumber.indexOf(player) == computerNumber.indexOf(player)) {
                strikeCnt++;
            }
        }
    }

    private void ballAfterStrike() {
        ballCnt -= strikeCnt;
    }
}
