package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    private static final int INPUT_LENGTH = 3;
    List<InputNumber> inputNumbers = new ArrayList<>();

    public InputNumbers(String input) {
        checkSize(input);
        createCharToInt(input);
        checkSameNumbers();
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

    private void checkSameNumbers() {
        for (int i = 0; i < inputNumbers.size() - 1; i++) {
            checkNextNumber(i);
        }
    }

    private void checkNextNumber(int index) {
        InputNumber currentNumber = inputNumbers.get(index);
        for (int j = index + 1; j < inputNumbers.size(); j++) {
            if (currentNumber.equals(inputNumbers.get(j))) {
                throw new IllegalArgumentException("입력된 값에 중복된 숫자가 있어요");
            }
        }
    }

    public int getNumber(int index) {
        InputNumber number = inputNumbers.get(index);
        return (number.getInputNumber());
    }

    @Override
    public String toString() {
        StringBuilder inputString = new StringBuilder();
        for (InputNumber number : inputNumbers) {
            inputString.append(number.toString());
        }
        return inputString.toString();
    }
}
