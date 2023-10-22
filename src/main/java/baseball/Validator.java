package baseball;

import java.util.List;

public class Validator {
    public void validateInputString(String inputString) {
        validateInputNoWhiteSpace(inputString);
        validateInputLength(inputString);
        validateInputNoZero(inputString);
    }

    public void validateInputNumber(List<Integer> inputNumbers, char input) {
        validateInputIsNumber(input);
        validateRedundancy(inputNumbers, Character.getNumericValue(input));
    }

    private void validateInputIsNumber(char input) {
        int inputNumber = Character.getNumericValue(input);
        if (inputNumber < 1 || inputNumber > 9) {
            throw new IllegalArgumentException("입력 중 숫자가 아닌 것이 포함되었습니다.");
        }
    }

    private void validateRedundancy(List<Integer> inputNumbers, int input) {
        if (inputNumbers.contains(input)) {
            throw new IllegalArgumentException("서로 다른 세자리 수여야 합니다.");
        }
    }

    private void validateInputLength(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("입력하신 수가 세자리가 아닙니다.");
        }
    }

    private void validateInputNoWhiteSpace(String inputString) {
        if (inputString.contains(" ")) {
            throw new IllegalArgumentException("입력에는 공백이 포함되면 안됩니다.");
        }
    }

    private void validateInputNoZero(String inputString) {
        if (inputString.contains("0")) {
            throw new IllegalArgumentException("1~9의 수로 이루어져 있어야 합니다.");
        }
    }
}
