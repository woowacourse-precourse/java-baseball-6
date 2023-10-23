package baseball.controller;

import java.util.HashSet;
import java.util.Set;

public class ValidationController {

    public void validateInput(String input) {
        validationIsNumeric(input);
        validateIsThreeDigits(input);
        validateNoDuplicateDigits(input);
    }

    // 숫자인지 검증
    private void validationIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    // 3자리 숫자인지 검증
    private void validateIsThreeDigits(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }


    // 중복된 숫자와, 0이 있는지 검증
    private void validateNoDuplicateDigits(String input) {
        Set<Character> digitSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if(!digitSet.add(ch) || ch == '0') {
                throw new IllegalArgumentException();
            }
        }
    }
}
