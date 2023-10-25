package baseball.controller;

import java.util.HashSet;
import java.util.Set;

public class CheckInput {
    private static final Integer NUMBER_LENGTH = 3;
    private static final String NUMBER_REGEX = "[^1-9]";
    private static final String BLANK = "";
    private static final String RESTART = "1";
    private static final String END = "2";
    

    public static void CheckNumber(String userInput) {
        String afterRegexInput = userInput.replaceAll(NUMBER_REGEX, BLANK);
        if (afterRegexInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void CheckLength(String userInput) {
        if (userInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void CheckDuplicate(String userInput) {

        Set<Character> inputSet = new HashSet<>();

        for (char c : userInput.toCharArray()) {
            inputSet.add(c);
        }
        if (inputSet.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void CheckNumberRules(String userInput) {
        CheckNumber(userInput);
        CheckLength(userInput);
        CheckDuplicate(userInput);
    }

    public static String CheckRestart(String userInput) {
        if (!userInput.equals(RESTART) && !userInput.equals(END)) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }
}
