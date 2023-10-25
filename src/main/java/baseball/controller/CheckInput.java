package baseball.controller;

import java.util.HashSet;
import java.util.Set;

public class CheckInput {
    private static final Integer NUMBER_LENGTH = 3;
    private static final String NUMBER_REGEX = "[^1-9]";
    private static final String BLANK = "";
    private static final String RESTART = "1";
    private static final String END = "2";


    public static void checkNumber(String userNumber) {
        String afterRegexInput = userNumber.replaceAll(NUMBER_REGEX, BLANK);
        if (afterRegexInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLength(String userNumber) {
        if (userNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicate(String userNumber) {

        Set<Character> inputSet = new HashSet<>();

        for (char c : userNumber.toCharArray()) {
            inputSet.add(c);
        }
        if (inputSet.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberRules(String userNumber) {
        checkNumber(userNumber);
        checkLength(userNumber);
        checkDuplicate(userNumber);
    }

    public static String checkRestart(String userNumber) {
        if (!userNumber.equals(RESTART) && !userNumber.equals(END)) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }
}
