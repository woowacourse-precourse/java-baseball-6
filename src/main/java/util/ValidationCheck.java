package util;

import java.util.HashSet;
import java.util.Set;

public class ValidationCheck {
    private static final int NUMBER_SIZE = 3;

    public void checkUserInput(String userInput) {
        if (userInput.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 3개까지만 입력할 수 있습니다.");
        }

        for (int i = 0; i < userInput.length(); i++) {
            if (!userInput.matches("[1-9]+")) {
                throw new IllegalArgumentException("1~9 범위 내의 '숫자'만 입력할 수 있습니다.");
            }
        }

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            numSet.add(userInput.charAt(i) - '0');
        }
        if (numSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("같은 숫자는 입력할 수 없습니다.");
        }
    }
}
