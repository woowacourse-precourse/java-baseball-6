package baseball.controller;

import baseball.service.ComputerNumberGenerator;
import baseball.util.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    InputView inputView;
    OutputView outputView;
    Validation validation = new Validation();

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void playball() {
        String nowComNumber = getComputerNumber();

        String userNumber = getUserNumber();


    }

    private String getComputerNumber() {
        ComputerNumberGenerator generator = ComputerNumberGenerator.getInstance();
        return validation.validateNumber(generator.generate());
    }

    private String getUserNumber() {
        String inputUserNumber = inputView.readUserNumber();
        return validation.validateNumber(inputUserNumber);
    }


}
