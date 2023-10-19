package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class UserInputValidator {

    public boolean hasLengthOfThree(String userInput) {
        if (userInput.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
    }

    public boolean isAllDigit(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자를 입력해 주세요");
            }
        }
        return true;
    }

    public boolean isUniqueNumber(String userInput) {
        Set<Character> numberSet = new HashSet<>();
        for (char c : userInput.toCharArray()) {
            numberSet.add(c);
        }
        if (numberSet.size() == 3) {
            return true;
        }
        throw new IllegalArgumentException("서로 다른 세 수를 입력해 주세요");
    }

    public boolean isInRangeOfOneToNine(String userInput) {
        for (String c : userInput.split("")) {
            if (Integer.parseInt(c) <= 0 || Integer.parseInt(c) > 9) {
                throw new IllegalArgumentException("1~9 사이의 수를 입력해 주세요");
            }
        }
        return true;
    }

    public boolean isValid(String userInput) {
        hasLengthOfThree(userInput);
        isAllDigit(userInput);
        isUniqueNumber(userInput);
        isInRangeOfOneToNine(userInput);
        return true;
    }
}
