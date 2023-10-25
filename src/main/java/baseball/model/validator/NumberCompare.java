package baseball.model.validator;

public class NumberCompare {
    private int strikeCnt;
    private int ballCnt;

    public int getStrike() {
        return strikeCnt;
    }

    public int[] getNumberCompareResult(String playerNumber, String computerNumber) {
        resetCnt();
        getBallCnt(playerNumber, computerNumber);
        getStrikeCnt(playerNumber, computerNumber);

        ballMinusStrike();

        return new int[]{ballCnt, strikeCnt};
    }
    public void getStrikeCnt(String player, String computer) {
        for (char playerNum : player.toCharArray()) {
            if (computer.indexOf(playerNum) == player.indexOf(playerNum)) {
                strikeCnt++;
            }
        }
    }

    public void getBallCnt(String player, String computer) {
        for (int i = 0; i < player.length(); i++) {
            // answer에 player가 정한 문자열이 있는지 확인
            if (computer.contains(Character.toString(player.charAt(i)))) {
                ballCnt++;
            }
        }
    }

    public void resetCnt(){
        ballCnt = 0;
        strikeCnt = 0;
    }

    // 스트라이크는 볼과 같은 걸로 처리하면 안됨.
    public void ballMinusStrike() {
        ballCnt -= strikeCnt;
    }
}
