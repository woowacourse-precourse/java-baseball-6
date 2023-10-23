package baseball.view;

import baseball.domain.BaseballMessageConst;
import baseball.domain.BaseballResult;

public class OutputView {


    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void printStartMessage() {
        println(BaseballMessageConst.START_GAME);
    }

    public void printInputNumberMessage() {
        print(BaseballMessageConst.INPUT_NUMBER);
    }

    public void printRestartOrExitMessage() {
        println(BaseballMessageConst.RESTART_OR_EXIT);
    }

    public void printBallStrikeResultMessage(BaseballResult baseballResult) {
        println(baseballResult.toString());
    }


}
