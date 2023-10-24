package baseball.view;

import baseball.common.config.BaseballMessageConst;
import baseball.domain.BaseballResult;

public class OutputView {


    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void printStartMessage() {
        println(BaseballMessageConst.START_GAME_MESSAGE);
    }

    public void printInputNumberMessage() {
        print(BaseballMessageConst.INPUT_NUMBER_MESSAGE);
    }

    public void printRestartOrExitMessage() {
        println(BaseballMessageConst.RESTART_OR_EXIT_MESSAGE);
    }

    public void printBallStrikeResultMessage(BaseballResult baseballResult) {
        println(baseballResult.toString());
    }


}
