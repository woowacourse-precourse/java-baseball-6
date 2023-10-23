package baseball.controller;

import static baseball.model.Constant.REPLAY_GAME;
import static baseball.model.Constant.START;

import baseball.model.DecimalNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private DecimalNumber decimalNumber = new DecimalNumber();
    private ComputerController computerController = new ComputerController(decimalNumber, outputView);

    public void run() {
        Boolean play = true;

        while (play) {
            outputView.printGuide(START);
            computerController.initComputer();
            playing();
            play = replay();
        }
    }

    private void playing() {
        Boolean isFailed = true;

        while (isFailed) {
            String inputNumber = inputView.inputGameNumber();
            decimalNumber.setUser(inputNumber);
            isFailed = computerController.checkAnswer();
        }
    }

    private Boolean replay() {
        String inputNumber = inputView.inputReplayNumber();
        Validation.validationReplayNumber(inputNumber);

        if (inputNumber.equals(REPLAY_GAME)) {
            return true;
        }
        return false;
    }
}
