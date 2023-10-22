package baseball.controller;

import baseball.model.Message;
import baseball.view.OutputView;

public class GameController {
    private static String START = Message.START.getMessage();

    private OutputView outputView = new OutputView();

    public void run() {
        outputView.printGame(START);
    }
}
