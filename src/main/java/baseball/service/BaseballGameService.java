package baseball.service;

import baseball.util.RandomNumberGenerator;
import baseball.util.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {
    BaseballGameCompareService baseballGameCompareService = new BaseballGameCompareService();

    public void startBaseballGame(int gameFlag) {
        if (gameFlag == 0) {    // 첫 실행
            printGameStartMessage();
        }
        if (gameFlag == 0 || gameFlag == 1) {   // 첫 실행과 재시작
            baseballGameCompareService.compareUserNumberAndRandomNumber(getUserNumber(), createRandomNumber());
        }
    }

    public void startBaseballGame(List<Integer> list) {
        baseballGameCompareService.compareUserNumberAndRandomNumber(getUserNumber(), list);
    }

    public void endBaseballGame() {
        printGameEndMessage();
        getRestartOrEndNumber();
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

    private void printGameEndMessage() {
        OutputView outputView = new OutputView();
        outputView.printGameEndMessage();
    }

    private void getRestartOrEndNumber() {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        String result = inputView.getRestartOrEndNumber();
        inputValidator.checkIsOneOrTwo(result);
        if (result.equals("1")) {
            startBaseballGame(1);
        }
    }
}
