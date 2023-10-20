package baseball.core.validator;

import java.util.HashSet;
import java.util.Set;

public class ValueValidator {
    private static final String WRONG_INPUT = "잘못된 입력입니다.";
    public boolean valid(String userInput){
        // 3개의 글자인지 체크
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }

        Set<Character> uniqueChars = new HashSet<>();
        // 글자가 전부 숫자인지 체크
        for (char c : userInput.toCharArray()) {
            if ((!Character.isDigit(c)) || (c == '0')) {
                throw new IllegalArgumentException(WRONG_INPUT);
            }
            uniqueChars.add(c);
        }

        if (uniqueChars.size() != 3) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
        return true;
    }

    public boolean reValid(String userInput) {
        // 1개의 글자인지 체크
        if (userInput.length() != 1) {
            return false;
        }

        char ch = userInput.charAt(0);
        return ch == '1' || ch == '2';
    }
}
