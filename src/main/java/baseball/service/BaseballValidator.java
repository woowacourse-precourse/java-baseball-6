package baseball.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.service.BaseballConstants.*;

public class BaseballValidator {
    public void validateBaseball(String number) {
        validateLength(number, BASEBALL_LENGTH);
        validateNumeric(number);
        validateUnique(number);
        validateRange(number, BASEBALL_START_NUMBER, BASEBALL_END_NUMBER);
    }

    // 기능: length 자릿수로 입력해야 한다
    private void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(length + " 자릿수로 입력해야 합니다.");
        }
    }

    // 기능: 숫자만 입력해야 한다
    private void validateNumeric(String input) {
        boolean onlyNumeric = Pattern.matches("^[\\d]*$", input);
        if (!onlyNumeric) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    // 기능: 서로 다른 숫자로만 입력해야 한다
    private void validateUnique(String input) {
        Set<Character> uniqueNums = new HashSet<>();
        for (int numberIdx = 0; numberIdx < input.length(); numberIdx++) {
            uniqueNums.add(input.charAt(numberIdx));
        }
        if (uniqueNums.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해야 합니다.");
        }
    }

    private void validateRange(String baseBalls, int start, int end) {
        for (char baseball : baseBalls.toCharArray()) {
            if (!isInRange(start, end, baseball - '0')) {
                throw new IllegalArgumentException(String.format("%d~%d 범위의 숫자만 허용됩니다.", start, end));
            }
        }
    }

    private boolean isInRange(int start, int end, int baseball) {
        return start <= baseball && baseball <= end;
    }
}
