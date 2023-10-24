package baseball.controller;

import java.util.HashSet;
import java.util.Set;

public class CheckInput {

    public static void CheckNumber(String userInput) {
        String afterRegexInput = userInput.replaceAll("[^1-9]", "");
        if (afterRegexInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void CheckLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void CheckDuplicate(String userInput) {

        Set<Character> inputSet = new HashSet<>();

        for (char c : userInput.toCharArray()) {
            inputSet.add(c);
        }
        if (inputSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void CheckNumberRules(String userInput) {
        CheckNumber(userInput);
        CheckLength(userInput);
        CheckDuplicate(userInput);
    }

    public static String CheckRestart(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }
}
