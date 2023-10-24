package baseball.validators;

import java.util.HashSet;
import java.util.Set;

public class UserNumberValidator implements Validator {

    private static final int VALID_LENGTH = 3;

    @Override
    public void validate(String userInput) {
        validateLength(userInput);
        validateNoDuplicate(userInput);
        validateNumberRange(userInput);
    }

    private void validateLength(String userInput) {
        if (userInput.length() != VALID_LENGTH) {
            throw new IllegalArgumentException("올바른 숫자 3가지를 입력해주세요.");
        }
    }

    private void validateNoDuplicate(String userInput) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : userInput.toCharArray()) {
            uniqueChars.add(ch);
        }
        if (uniqueChars.size() != VALID_LENGTH) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void validateNumberRange(String userInput) {
        for (char ch : userInput.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("1부터 9사이의 숫자만 입력해주세요");
            }
        }
    }
}
