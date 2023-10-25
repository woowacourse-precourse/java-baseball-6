package baseball;

import constant.Constant;
import constant.GameMessage;
import java.util.List;

public class Hint {
    private int strikeCnt;
    private int ballCnt;

    public Hint() {
        this.strikeCnt = Constant.INITIAL_VALUE.getValue();
        this.ballCnt = Constant.INITIAL_VALUE.getValue();
    }

    public void getHint(List<Integer> playerNmbs, List<Integer> targetNmbs) {
        this.strikeCnt = Constant.INITIAL_VALUE.getValue();
        this.ballCnt = Constant.INITIAL_VALUE.getValue();

        countStrikeCntAndBallCnt(playerNmbs, targetNmbs);

        printHint();
    }

    private void printHint() {
        if (strikeCnt > Constant.NO_EXIST_VALUE.getValue() && ballCnt == Constant.NO_EXIST_VALUE.getValue()) {
            System.out.println(this.strikeCnt + GameMessage.STRIKE.getMessage());
            return;
        }
        if (strikeCnt == Constant.NO_EXIST_VALUE.getValue() && ballCnt > Constant.NO_EXIST_VALUE.getValue()) {
            System.out.println(this.ballCnt + GameMessage.BALL.getMessage());
            return;
        }
        if (strikeCnt == Constant.NO_EXIST_VALUE.getValue() && ballCnt == Constant.NO_EXIST_VALUE.getValue()) {
            System.out.println(GameMessage.NOTHING.getMessage());
            return;
        }
        System.out.println(
                this.ballCnt + GameMessage.BALL.getMessage() + " " + this.strikeCnt + GameMessage.STRIKE.getMessage());
    }
}
