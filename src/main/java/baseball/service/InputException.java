package baseball.service;

import baseball.domain.GameRule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputException {
    public void checkUserNumber(String userInput) {
        checkRestartNumber(userInput);
        checkUserNumberRange(userInput);
        checkUserNumberDuplicated(userInput);
    }

    public void checkRestartNumber(String userInput) {
        int restartNumber = changeStringToNumber(userInput);
        if (restartNumber != GameRule.restartNumber && restartNumber != GameRule.endGameNumber) {
            throw new IllegalArgumentException();
        }
    }

    public void CheckUserNumberLength(String userInput) {
        if (userInput.length() != GameRule.userNumberLength) {
            throw new IllegalArgumentException();
        }
    }

    public void checkUserNumberRange(String userInput) {
        List<Integer> userNumber = changeStringToNumbers(userInput);
        for (Integer num : userNumber) {
            if (num < GameRule.userNumberMin || num > GameRule.userNumberMax) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkUserNumberDuplicated(String userInput) {
        List<Integer> userNumber = changeStringToNumbers(userInput);
        Set<Integer> userSet = new HashSet<>(userNumber);
        if (userNumber.size() != userSet.size()) {
            throw new IllegalArgumentException();
        }

    }

    public Integer changeStringToNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> changeStringToNumbers(String userInput) {
        try {
            int[] arr = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
