package baseball.model;

import baseball.exception.InputValidator;
import baseball.view.InputView;

import javax.xml.validation.Validator;
import java.util.List;

public class Player {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private final InputView inputView;
    private final Util util;
    private List<Integer> numbers;
    private final InputValidator inputValidator;
    private final int settingNumberLength;

    public Player(int numberLength) {
        this.inputView = new InputView();
        this.settingNumberLength = numberLength;
        this.util = new Util();
        this.inputValidator = new InputValidator();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setPlayerNumbersWithString(String input) {
        List<Integer> inputNumbers = util.parseToNumberList(input);

        inputValidate(inputNumbers);

        this.numbers = inputNumbers;
    }

    private void inputValidate(List<Integer> inputNumbers) {
        if(!inputValidator.isValidRange(inputNumbers, MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)) {
            throw new IllegalArgumentException();
        }

        if(!inputValidator.isUniqueDigits(inputNumbers)) {
            throw new IllegalArgumentException();
        }

        if(!inputValidator.isValidLength(inputNumbers, settingNumberLength)) {
            throw new IllegalArgumentException();
        }
    }
}
