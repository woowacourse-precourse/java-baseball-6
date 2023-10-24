package baseball;

import java.util.HashSet;
import java.util.Set;

public class UserNumberValidator {

    public void validateThreeDigitNumber(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다");
        }
    }

    public void validateNumberRange(String userNumber) {
        for (char num : userNumber.toCharArray()) {
            checkNumberRange(num - '0');
        }
    }

    public void validateNumericValue(String userNumber) {
        for (char num : userNumber.toCharArray()) {
            checkNumericValue(num);
        }
    }

    public void validateDuplicatedNumber(String userNumber) {
        Set<Character> set = new HashSet<>();
        for (char digit : userNumber.toCharArray()) {
            set.add(digit);
        }

        if (isDuplicated(userNumber, set)) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다");
        }
    }

    private boolean isDuplicated(String userNumber, Set<Character> set) {
        return userNumber.length() != set.size();
    }

    private void checkNumberRange(int userNumber) {
        if (userNumber < 1 || userNumber > 9) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력할 수 있습니다");
        }
    }

    private void checkNumericValue(char userNumber) {
        if (Character.isAlphabetic(userNumber)) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 들어올 수 없습니다");
        }
    }
}
