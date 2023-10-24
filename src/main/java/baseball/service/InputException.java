package baseball.service;

import baseball.domain.GameRule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputException {
    public static void checkUserNumber(String userInput) {
        CheckUserNumberLength(userInput);
        checkUserNumberRange(userInput);
        checkUserNumberDuplicated(userInput);
    }

    public static void checkRestartNumber(String userInput) {
        int restartNumber = changeStringToNumber(userInput);
        if (restartNumber != GameRule.restartNumber && restartNumber != GameRule.endGameNumber) {
            throw new IllegalArgumentException();
        }
    }

    public static void CheckUserNumberLength(String userInput) {
        if (userInput.length() != GameRule.userNumberLength) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkUserNumberRange(String userInput) {
        List<Integer> userNumber = changeStringToNumbers(userInput);
        for (Integer num : userNumber) {
            if (num < GameRule.userNumberMin || num > GameRule.userNumberMax) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkUserNumberDuplicated(String userInput) {
        List<Integer> userNumber = changeStringToNumbers(userInput);
        Set<Integer> userSet = new HashSet<>(userNumber);
        if (userNumber.size() != userSet.size()) {
            throw new IllegalArgumentException();
        }

    }

    public static Integer changeStringToNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> changeStringToNumbers(String userInput) {
        try {
            int[] arr = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
