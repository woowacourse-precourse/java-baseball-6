package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();


    public boolean gameStart() {
        inputView.printStart();
        startInspection();

        return inputView.printEnd() == 1;
    }

    public void startInspection() {
        ComputerNumber computerNumber = new ComputerNumber();
        UserNumber userNumber = new UserNumber();

        while(computerNumber.verifyEnd()) {
            userNumber.setNumber(inputView.printInsertNumber());
            computerNumber.verifyNumber(userNumber.getNumber());
            outputView.printResult(computerNumber.getStrike(), computerNumber.getBall());
        }
    }
}
