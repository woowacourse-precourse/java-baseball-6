package baseball.view;

import baseball.util.MessageUtil;

public class OutputView {
    public void printGameStartMessage(){
        MessageUtil.GAME_START_MESSAGE.messagePrintln();
    }
    public void printGameNumberInputMessage(){
        MessageUtil.INPUT_BASEBALL_NUMBER_MESSAGE.messagePrint();
    }
    public void printGameRetryMessage(){
        MessageUtil.GAME_RETRY_MESSAGE.messagePrintln();
    }

    public void printGameEndMessage(){
        MessageUtil.GAME_SUCCESS_MESSAGE.messagePrintln();
    }
}
