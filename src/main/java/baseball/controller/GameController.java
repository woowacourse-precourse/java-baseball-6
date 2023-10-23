package baseball.controller;

import static baseball.model.Message.START;

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
            outputView.printGuide(START.getMessage());
            computerController.initComputer();
            playing();
            play = replay();
        }
    }

    private void playing() {
        Boolean isSuccess = true;

        while (isSuccess) {
            String inputNumber = inputView.inputGameNumber();
            decimalNumber.setUser(inputNumber);
            isSuccess = computerController.checkAnswer();
        }
    }

    private Boolean replay() {
        String inputNumber = inputView.inputReplayNumber();
        Validation.validationReplayNumber(inputNumber);
        //enum으로 뺄지 말지 생각
        if (inputNumber.equals("1")) {
            return true;
        }
        return false;
    }
}
