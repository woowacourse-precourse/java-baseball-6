package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import baseball.util.MagicNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.util.MagicNumber.RESTART;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void process() {
        boolean continueGame = true;

        while(continueGame) {
            continueGame = gameStart();
        }
    }

    public boolean gameStart() {
        inputView.printStart();
        startInspection();

        return inputView.printEnd() == RESTART.getNumber();
    }

    public void startInspection() {
        ComputerNumber computerNumber = new ComputerNumber();
        UserNumber userNumber = new UserNumber();

        while(!computerNumber.verifyEnd()) {
            userNumber.setNumber(inputView.printInsertNumber());
            computerNumber.verifyNumber(userNumber.getNumber());
            outputView.printResult(computerNumber.getStrike(), computerNumber.getBall());
        }

        inputView.printCorrect();
    }
}
