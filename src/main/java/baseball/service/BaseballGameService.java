package baseball.service;

import baseball.util.RandomNumberGenerator;
import baseball.util.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameService {
    public void startBaseballGame() {
        printGameStartMessage();
        getUserNumber();
    }

    private void printGameStartMessage() {
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();
    }

    private void getUserNumber() {
        InputView inputView = new InputView();
        String userNumber = inputView.getUserNumber();
        checkUserNumberValidate(userNumber);
    }

    private void checkUserNumberValidate(String userInputNumber) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkInputValidation(userInputNumber);
    }

    private List<Integer> createRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return randomNumberGenerator.createRandomNumber();
    }
}
