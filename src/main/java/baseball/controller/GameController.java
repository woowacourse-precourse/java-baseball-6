package baseball.controller;

import baseball.model.Message;
import baseball.view.OutputView;

public class GameController {
    private String START = Message.START.getMessage();
    private OutputView outputView = new OutputView();
    private Validation validation = new Validation();
    private RandomNumber randomNumber = new RandomNumber(validation);

    public void run() {
        outputView.printGame(START);
        randomNumber.generateRandomNum();
    }
}
