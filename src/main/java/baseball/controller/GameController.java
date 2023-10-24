package baseball.controller;

import static baseball.model.Constant.FINISHED;
import static baseball.model.Constant.REPLAY_GAME;
import static baseball.model.Constant.RUNNING;
import static baseball.model.Constant.START;

import baseball.model.DecimalNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    DecimalNumber decimalNumber;
    ComputerController computerController;

    public GameController(DecimalNumber decimalNumber, ComputerController computerController) {
        this.decimalNumber = decimalNumber;
        this.computerController = computerController;
    }

    public void run() {
        boolean status = RUNNING;

        OutputView.printGuide(START);
        while (status == RUNNING) {
            computerController.initComputer();
            playing();
            status = replay();
        }
    }

    private void playing() {
        boolean status = RUNNING;

        while (status == RUNNING) {
            String inputNumber = InputView.inputGameNumber();
            decimalNumber.setUser(inputNumber);
            status = computerController.checkAnswer();
        }
    }

    private boolean replay() {
        String inputNumber = InputView.inputReplayNumber();
        Validation.validationReplayNumber(inputNumber);

        if (inputNumber.equals(REPLAY_GAME)) {
            return RUNNING;
        }
        return FINISHED;
    }
}
