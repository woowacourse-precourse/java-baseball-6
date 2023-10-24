package baseball.utils;

import java.util.HashSet;

public class ValidationUtil {
    private final HashSet<Character> charSet = new HashSet<>();
    private static final int INPUT_LENGTH = 3;
    private static final char NUMBER_MIN = '1';
    private static final char NUMBER_MAX = '9';
    private static final String LENGTH_MISMATCH = "세 자리로 입력해 주세요.";
    private static final String RANGE_MISMATCH = NUMBER_MIN + " 이상 " + NUMBER_MAX + " 이하 숫자로 입력해 주세요.";
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
        if (userInput.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_MISMATCH);
        }
    }

    private void checkRange(char ch) {
        if (ch < NUMBER_MIN || ch > NUMBER_MAX) {
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
