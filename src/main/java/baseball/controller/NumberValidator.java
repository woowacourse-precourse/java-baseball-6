package baseball.controller;

import java.util.List;
import java.util.stream.Collectors;

public class NumberValidator {
    private final static int MINIMUM_NUM_IN_RANGE = 1;
    private final static int MAXIMUM_NUM_IN_RANGE = 9;
    private final static int LIST_SIZE = 3;

    public static String validateString(String inputString) {
        if (isEmpty(inputString) || !isNumber(inputString)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        } else if (!isThreeDigit(inputString)) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요");
        }
        validateList(StringToIntList(inputString));
        return inputString;
    }

    public static void validateList(List<Integer> intList) {
        if (!isInRange(intList)) {
            throw new IllegalArgumentException("각자리의 숫자가 1부터 9사이의 숫자로 이루어져야 합니다");
        } else if (!isDistinct(intList)) {
            throw new IllegalArgumentException("중복된 숫자가 존재하지 않아야 합니다");
        }
    }

    private static boolean isEmpty(String inputString) {
        return inputString == null || inputString.isBlank();
    }

    private static boolean isNumber(String inputString) {
        return inputString.chars().allMatch(Character::isDigit);
    }

    private static boolean isThreeDigit(String inputString) {
        return inputString.length() == LIST_SIZE;
    }

    private static boolean isInRange(List<Integer> intList) {
        return intList.stream()
                .allMatch(num -> num >= MINIMUM_NUM_IN_RANGE && num <= MAXIMUM_NUM_IN_RANGE);
    }

    private static boolean isDistinct(List<Integer> intList) {
        return intList.stream().distinct().count() == LIST_SIZE;
    }

    private static List<Integer> StringToIntList(String inputString) {
        return inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
