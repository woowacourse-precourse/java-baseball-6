package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputNum {
    private static final int INPUT_LENGTH = 3;
    private static final String INPUT_CONTENT_REGEX = "^[1-9]+$";
    private List<Integer> inputNumbers;

    public InputNum() {
        this.inputNumbers = new ArrayList<>();
    }

    public List<Integer> convertInputToNumbers(String inputNum) {
        this.inputNumbers = new ArrayList<>();
        if (!isValidInput(inputNum)) {
            throw new IllegalArgumentException();
        }
        for (char digit : inputNum.toCharArray()) {
            inputNumbers.add(Character.getNumericValue(digit));
        }
        return inputNumbers;
    }

    public boolean isValidInput(String inputNum) {
        Set<Character> inputSet = new HashSet<>();
        for (char digit : inputNum.toCharArray()) {
            inputSet.add(digit);
        }
        if (inputSet.size() < INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
        return inputNum.length() == INPUT_LENGTH && inputNum.matches(INPUT_CONTENT_REGEX);
    }
}