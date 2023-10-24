package baseball;

import java.util.HashSet;
import java.util.Set;

public abstract class UserNumberValidator {

    public static void validateThreeDigitNumber(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다");
        }
    }

    public static void validateDuplicatedNumber(String userNumber) {
        Set<Character> set = new HashSet<>();
        for (char digit : userNumber.toCharArray()) {
            set.add(digit);
        }

        if (isDuplicated(userNumber, set)) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다");
        }
    }

    private static boolean isDuplicated(String userNumber, Set<Character> set) {
        return userNumber.length() != set.size();
    }
}
