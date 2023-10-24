package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputNum {
    private static final int INPUT_LENGTH = 3;
    private static final String INPUT_CONTENT = "^[1-9]+$";
    private List<Integer> inputArr;

    public InputNum() {
        this.inputArr = new ArrayList<>();
    }

    public List<Integer> convertInputToArr(String inputNum) {
        this.inputArr = new ArrayList<>();
        if (!isValidInput(inputNum)) {
            throw new IllegalArgumentException();
        }
        for (char digit : inputNum.toCharArray()) {
            inputArr.add(Character.getNumericValue(digit));
        }
        return inputArr;
    }

    public boolean isValidInput(String inputNum) {
        Set<Character> inputSet = new HashSet<>();
        for (char digit : inputNum.toCharArray()) {
            inputSet.add(digit);
        }
        if (inputSet.size() < 3) {
            throw new IllegalArgumentException();
        }
        return inputNum.length() == INPUT_LENGTH && inputNum.matches(INPUT_CONTENT);
    }
}