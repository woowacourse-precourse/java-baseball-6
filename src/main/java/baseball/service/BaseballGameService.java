package baseball.service;

import baseball.util.RandomNumberGenerator;
import baseball.util.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {
    BaseballGameCompareService baseballGameCompareService = new BaseballGameCompareService();

    public void startBaseballGame() {
        printGameStartMessage();
        baseballGameCompareService.compareUserNumberAndRandomNumber(getUserNumber(), createRandomNumber());
    }

    private void printGameStartMessage() {
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();
    }

    private List<Integer> getUserNumber() {
        InputView inputView = new InputView();
        String userNumber = inputView.getUserNumber();
        checkUserNumberValidate(userNumber);
        return stringToList(userNumber);
    }

    private void checkUserNumberValidate(String userInputNumber) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkInputValidation(userInputNumber);
    }

    private List<Integer> createRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return randomNumberGenerator.createRandomNumber();
    }

    private List<Integer> stringToList(String target) {
        List<Integer> list = new ArrayList<>();
        for (char alpha : target.toCharArray()) {
            list.add(alpha - '0');
        }
        return list;
    }
}
