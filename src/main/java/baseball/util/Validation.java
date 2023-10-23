package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public final static int MAX_INPUT_LENGTH = 3;
    private final static int MAX_EXIT_INPUT_LENGTH = 1;

    public static void validNumber(String number) {
        containsZero(number);
        validLength(number, MAX_INPUT_LENGTH);
        containsLetter(number, MAX_INPUT_LENGTH);
        duplicateNumber(number);
    }

    public static void validExitNumber(String number) {
        validLength(number, MAX_EXIT_INPUT_LENGTH);
        containsLetter(number, MAX_EXIT_INPUT_LENGTH);
        isOneOrTwo(number);
    }

    public static void containsZero(String number) {
        if (number.contains("0")) {
            throw new IllegalArgumentException("입력 문자열에 0이 포함되었습니다.");
        }
    }

    public static void containsLetter(String number, int maxLength) {
        String removedNumberString = number.replaceAll("[^1-9]", "");
        int numberLength = removedNumberString.length();

        if (numberLength < maxLength) {
            throw new IllegalArgumentException("입력 문자열은 숫자이어야 합니다.");
        }
    }

    public static void validLength(String number, int maxLength) {
        int numberLength = number.length();

        if (numberLength != maxLength) {
            throw new IllegalArgumentException("입력 문자열의 길이가 " + maxLength + "이 되어야 합니다.");
        }
    }

    public static void duplicateNumber(String number) {
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < MAX_INPUT_LENGTH; i++) {
            int num = Character.getNumericValue(number.charAt(i));
            numSet.add(num);
        }

        int setSize = numSet.size();

        if (setSize < MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력 문자열은 서로 다른 3자리 수이어야 합니다.");
        }
    }

    public static void isOneOrTwo(String number) {
        String replacedString = number.replaceAll("[^1-2]", "");

        if (replacedString.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 1 또는 2가 아닙니다.");
        }
    }
}
