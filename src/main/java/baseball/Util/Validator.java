package baseball.Util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final String EMPTY = "";
    public static final String NULL_OR_EMPTY_MESSAGE = "값을 입력해주세요";
    public static final String NOT_THREE_DIGIT_NUMBER_MESSAGE = "세자리 숫자를 입력해주세요";
    public static final String NOT_UNIQUE_NUMBER_MESSAGE = "중복된 숫자가 있습니다.";
    public static final String NOT_ONE_OR_TWO = "1 또는 2만 입력해주세요";

    public static void isNullOrEmpty(String input) {
        if (input == null || input.equals(EMPTY)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_MESSAGE);
        }
    }

    public static void isThreeDigitNumber(String input) {
        Pattern pattern = Pattern.compile("[1-9]{3}");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_THREE_DIGIT_NUMBER_MESSAGE);
        }
    }

    public static void isUniqueNumber(String input) {
        Set<Character> uniqueNumber = new HashSet<Character>();
        for (char number : input.toCharArray()) {
            checkDuplicatesAndAdd(uniqueNumber, number);
        }
    }

    private static void checkDuplicatesAndAdd(Set<Character> uniqueNumber, char number) {
        if (uniqueNumber.contains(number)) {
            throw new IllegalArgumentException(NOT_UNIQUE_NUMBER_MESSAGE);
        }
        uniqueNumber.add(number);
    }

    public static void isOneOrTwo(String input) {
        Pattern pattern = Pattern.compile("[1-2]{1}");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_ONE_OR_TWO);
        }
    }
}
