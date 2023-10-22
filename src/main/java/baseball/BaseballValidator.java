package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class BaseballValidator {
    public void validatePlayerBallInput(String number) {
        validateLength(number, 3);
        validateNumeric(number);
        validateUnique(number);
        validateNoneZero(number);
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

    private void validateNoneZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("1~9 숫자만 허용됩니다. 0이 포함 되었는지 확인하세요.");
        }
    }
}
