package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private List<Integer> parseUserInput(String userInput) {
        List<Integer> userNumbers = parseInputNumbers(userInput);
        validateUserInput(userNumbers);
        return userNumbers;
    }

    private List<Integer> parseInputNumbers(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (char digitChar : userInput.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            userNumbers.add(digit);
        }
        return userNumbers;
    }

    private void validateUserInput(List<Integer> userNumbers) {
        if (userNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }

        if (!areNumbersInRange(userNumbers)) {
            throw new IllegalArgumentException("1에서 9 사이의 수만 입력 가능합니다.");
        }

        if (!areNumbersDistinct(userNumbers)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }

    private boolean areNumbersInRange(List<Integer> userNumbers) {
        for (int num : userNumbers) {
            if (num < 1 || num > 9) {
                return false;
            }
        }
        return true;
    }

    private boolean areNumbersDistinct(List<Integer> userNumbers) {
        for (int i = 0; i < userNumbers.size(); i++) {
            for (int j = i + 1; j < userNumbers.size(); j++) {
                if (userNumbers.get(i).equals(userNumbers.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
