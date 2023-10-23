package baseball.controller;

import static baseball.model.Constant.FINISHED;
import static baseball.model.Constant.ON_GOING;
import static baseball.model.Constant.REPLAY_GAME;
import static baseball.model.Constant.START;

import baseball.model.DecimalNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    DecimalNumber decimalNumber = new DecimalNumber();
    ComputerController computerController = new ComputerController(decimalNumber);

    public void run() {
        boolean play = ON_GOING;

        while (play) {
            OutputView.printGuide(START);
            computerController.initComputer();
            playing();
            play = replay();
        }
    }

    private void playing() {
        boolean isFailed = ON_GOING;

        while (isFailed) {
            String inputNumber = InputView.inputGameNumber();
            decimalNumber.setUser(inputNumber);
            isFailed = computerController.checkAnswer();
        }
    }

    private boolean replay() {
        String inputNumber = InputView.inputReplayNumber();
        Validation.validationReplayNumber(inputNumber);

        if (inputNumber.equals(REPLAY_GAME)) {
            return ON_GOING;
        }
        return FINISHED;
    }
}
