package baseball;

import java.util.HashSet;
import java.util.Set;

public class ValidAnswer {
    public static int DIGITS_LENGTH = 3;
    public static String DIGITS_PATTERN = "^[1-9]+$";

    public String getUserNumber(String userNumber) {
        if (!isThreeLength(userNumber)) {
            throw new IllegalArgumentException("숫자는 3개만 입력할 수 있습니다.");
        }
        if (!isRangeDigits(userNumber)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        if (!isDuplicate(userNumber)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
        return userNumber;
    }

    private boolean isThreeLength(String userInputNumber) {
        return userInputNumber.length() == DIGITS_LENGTH;
    }

    private boolean isRangeDigits(String userInputNumber) {
        return userInputNumber.matches(DIGITS_PATTERN);
    }

    private boolean isDuplicate(String userInputNumber) {
        Set<Character> DuplicateDigits = new HashSet<>();
        for (char charcater : userInputNumber.toCharArray()) {
            DuplicateDigits.add(charcater);
        }
        return userInputNumber.length() == DuplicateDigits.size();
    }
}
