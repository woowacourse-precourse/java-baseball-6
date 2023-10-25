package baseball.service;

import baseball.utils.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.constant.Number.NUMBER_LENGTH;

public class UserService {
    final static InputView inputView = new InputView();
    final static OutputView outputView = new OutputView();
    final static Validation validation = new Validation();

    public List<Integer> readUserNumber() {
        outputView.userInputMessage();
        String userNumbers = inputView.getUserNumber();
        List<Integer> listNumbers = validateUserNumber(userNumbers);

        return listNumbers;
    }

    private List<Integer> validateUserNumber(String userNumber) {
        validation.checkNumberLength(userNumber, NUMBER_LENGTH);
        List<Integer> numberList = validation.isAllDigits(userNumber);
        validation.hasDuplicate(numberList);

        return numberList;
    }

    public Integer readRetryNumber() {
        outputView.retryMessage();
        String retryNumber = inputView.getRetryNumber();
        Integer retryIntegerNumber = validateRetryNumber(retryNumber);

        return retryIntegerNumber;
    }

    private Integer validateRetryNumber(String retryNumber) {
        validation.checkNumberLength(retryNumber, 1);
        Integer retryInteger = validation.isDigit(retryNumber.charAt(0));
        validation.isValidNumber(retryInteger);

        return retryInteger;
    }
}
