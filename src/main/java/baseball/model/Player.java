package baseball.model;

import baseball.exception.InputValidator;
import java.util.List;
public class Player {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int GAME_NUMBER_LENGTH = 3;
    private final InputValidator inputValidator;
    private final Util util;
    private List<Integer> numbers;

    public Player() {
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

        if(!inputValidator.isValidLength(inputNumbers, GAME_NUMBER_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }
}
