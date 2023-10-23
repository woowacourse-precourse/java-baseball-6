package baseball.validation;

import java.util.HashSet;
import java.util.Set;

public class InputNumberValidation {
    public static void userInputNumberValidation(String inputNumber) {
        validateInputNumberLength(inputNumber);
        validateInputNumberDuplicate(inputNumber);
    }

    public static void validateInputNumberLength(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력 숫자는 3개여야 합니다.");
        }
    }

    public static void validateInputNumberDuplicate(String inputNumber) {
        Set<Character> inputNumberDuplicate = new HashSet<>();
        for (char parsedChar : inputNumber.toCharArray()) {
            if (inputNumberDuplicate.contains(parsedChar)) {
                throw new IllegalArgumentException("입력된 숫자는 중복을 가질 수 없습니다.");
            }
            inputNumberDuplicate.add(parsedChar);
        }
    }

    public static void validateParsedChar(char parsedChar) {
        if (!Character.isDigit(parsedChar) || parsedChar == '0') {
            throw new IllegalArgumentException("1부터 9까지의 범위를 가진 유효한 숫자가 입력되어야 합니다.");
        }
    }
}
