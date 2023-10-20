package baseball.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    public static final String REQUEST_INPUT_MESSAGE  = "숫자를 입력해주세요 : ";
    public static final String EMPTY = "";
    public static final String NULL_OR_EMPTY_MESSAGE = "값을 입력해주세요";
    public static final String NOT_THREE_DIGIT_NUMBER_MESSAGE = "세자리 숫자를 입력해주세요";
    public static final String NOT_UNIQUE_NUMBER_MESSAGE = "중복된 숫자가 있습니다.";

    public static String requestInputNumbers() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public static void validateInput(String input) {
        isNullOrEmpty(input);
        input = input.trim();
        isThreeDigitNumber(input);
        isUniqueNumber(input);
    }

    private static void isNullOrEmpty(String input) {
        if (input == null || input.equals(EMPTY)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_MESSAGE);
        }
    }

    private static void isThreeDigitNumber(String input) {
        Pattern pattern = Pattern.compile("[1-9]{3}");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_THREE_DIGIT_NUMBER_MESSAGE);
        }
    }

    private static void isUniqueNumber(String input) {
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
}
