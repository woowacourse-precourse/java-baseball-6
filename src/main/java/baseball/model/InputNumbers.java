package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    private static final int INPUT_LENGTH = 3;
    List<InputNumber> inputNumbers = new ArrayList<>();

    public InputNumbers(String input) {
        checkSize(input);
        createCharToInt(input);
    }

    private void checkSize(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("3자리가 아님");
        }
    }

    private void createCharToInt(String input) {
        for (int i = 0; i < INPUT_LENGTH; i++) {
            char tmpNumber = input.charAt(i);
            InputNumber inputNumber = new InputNumber(tmpNumber);
            inputNumbers.add(inputNumber);
        }
    }
}
