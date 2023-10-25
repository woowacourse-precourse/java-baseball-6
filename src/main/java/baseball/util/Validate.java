package baseball.util;

public class Validate {
    private final Compare compare;

    public Validate() {
        compare = new Compare();
    }

    public int[] getCompareResult(String playerNumber, String computerNumber){
        return compare.getStrikeBallCnt(playerNumber, computerNumber);
    }

    public boolean isOut() {
        return compare.getStrikeCnt() == 3;
    }

}
