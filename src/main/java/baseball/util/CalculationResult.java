package baseball.util;

import static baseball.util.NumberConstants.*;

import java.util.List;

public class CalculationResult {

    private int strikeCnt;
    private int ballCnt;

    public CalculationResult() {
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void calStrikeAndBall(List<Integer> comNumberList, List<Integer> userNumberList) {
        strikeCnt = 0;
        ballCnt = 0;
        for (int i = 0; i < LIMIT_NUMBERS_SIZE.getValue(); i++) {
            if (comNumberList.get(i).equals(userNumberList.get(i))) {
                strikeCnt++;
            } else if (userNumberList.contains(comNumberList.get(i))) {
                ballCnt++;
            }
        }
    }

}
