package baseball.view;

import baseball.constant.message.GameMessage;
import baseball.constant.value.GameValue;

public class GameView {

    public GameView() {
        printStartMessage();
    }

    private void printStartMessage() {
        System.out.println(GameMessage.MESSAGE_GAME_START);
    }

    public void printRequestInput() {
        System.out.print(GameMessage.MESSAGE_INPUT);
    }

    public void printThreeStrike() {
        System.out.println(GameValue.THREE + GameMessage.STRIKE);
    }

    public void printGameEnd() {
        System.out.println(GameMessage.MESSAGE_GAME_END);
    }

    public void printRetry() {
        System.out.println(GameMessage.MESSAGE_GAME_RETRY);
    }

    public void printBallCount(int ballCnt) {
        System.out.println(ballCnt + GameMessage.BALL);
    }

    public void printStrikeCount(int strikeCnt) {
        System.out.println(strikeCnt + GameMessage.STRIKE);
    }

    public void printBallCntAndStrikeCnt(int ballCnt, int strikeCnt) {
        System.out.println(ballCnt + GameMessage.BALL + strikeCnt + GameMessage.STRIKE);
    }

    public void printNothing() {
        System.out.println(GameMessage.NOTHING);
    }
}
