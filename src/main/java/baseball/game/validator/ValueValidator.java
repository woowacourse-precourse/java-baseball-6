package baseball.game.validator;

import java.util.List;

public class ValueValidator {
    public boolean valid(String userInput){
        // 3개의 글자인지 체크
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 글자가 전부 숫자인지 체크
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return true;
    }

    public boolean reValid(String userInput) {
        // 1개의 글자인지 체크
        if (userInput.length() != 1) {
            return false;
        }

        char ch = userInput.charAt(0);
        return Character.isDigit(ch);
    }
}
