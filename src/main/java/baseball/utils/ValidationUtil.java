package baseball.utils;

import java.util.HashSet;

public class ValidationUtil {
    private final HashSet<Character> charSet = new HashSet<>();
    private static final String LENGTH_MISMATCH = "세 자리로 입력해 주세요.";
    private static final String RANGE_MISMATCH = "1이상 9 이하 숫자로 입력해 주세요.";
    private static final String DUPLICATE_EXIST = "중복되는 숫자가 존재합니다.";

    public void validate(String userInput) throws IllegalArgumentException {
        charSet.clear();

        checkLength(userInput);
        for (int i = 0; i < userInput.length(); i++) {
            checkRange(userInput.charAt(i));
            checkDuplicate(userInput.charAt(i));
        }
    }

    private void checkLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(LENGTH_MISMATCH);
        }
    }

    private void checkRange(char ch) {
        if (ch < '1' || ch > '9') {
            throw new IllegalArgumentException(RANGE_MISMATCH);
        }
    }

    private void checkDuplicate(char ch) {
        if (charSet.contains(ch)) {
            throw new IllegalArgumentException(DUPLICATE_EXIST);
        }
        charSet.add(ch);
    }
}
