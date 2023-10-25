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

    private void countStrikeCntAndBallCnt(List<Integer> playerNmbs, List<Integer> targetNmbs) {
        for (int idx = 0; idx < Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue(); idx++) {
            validateStrikeAndBall(idx, playerNmbs, targetNmbs);
        }
    }

    private void validateStrikeAndBall(int index, List<Integer> playerNmbs, List<Integer> targetNmbs) {
        if (validateStrike(playerNmbs.get(index), targetNmbs.get(index))) {
            return;
        }
        validateBall(playerNmbs.get(index), targetNmbs);
    }

    private boolean validateStrike(int playerNmb, int targetNmb) {
        if (playerNmb == targetNmb) {
            this.strikeCnt++;
            return true;
        }
        return false;
    }

    private void validateBall(int playerNmb, List<Integer> targetNmbs) {
        if (targetNmbs.contains(playerNmb)) {
            this.ballCnt++;
        }
    }
}
