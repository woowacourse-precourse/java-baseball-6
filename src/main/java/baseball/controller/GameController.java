package baseball.controller;

import baseball.model.Message;
import baseball.view.OutputView;

public class GameController {
    private String START = Message.START.getMessage();
    private OutputView outputView = new OutputView();
    private RandomNumber randomNumber = new RandomNumber();

    public void run() {
        outputView.printGame(START);
        randomNumber.generateRandomNum();


    }
}
