package baseball.controller;

import java.util.List;
import java.util.stream.Collectors;

public class NumberValidator {
    private final static int MINIMUM_NUM_IN_RANGE = 1;
    private final static int MAXIMUM_NUM_IN_RANGE = 9;
    private final static int LIST_SIZE = 3;

    public static void validateString(String number) {
        if(isEmpty(number)|| !isDigit(number)){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        else if(!isThreeDigit(number)){
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요");
        }
        validateList(StringToList(number));
    }

    public static void validateList(List<Integer> list) {
        if(!isInRange(list)){
            throw new IllegalArgumentException("각자리의 숫자가 1부터 9사이의 숫자로 이루어져야 합니다");
        }
        else if(!isDistinct(list)){
            throw new IllegalArgumentException("중복된 숫자가 존재하지 않아야 합니다");
        }
    }

    private static boolean isEmpty(String number) {
        return number == null || number.isBlank();
    }

    private static boolean isDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private static boolean isThreeDigit(String number) {
        return number.length() == LIST_SIZE;
    }

    private static boolean isInRange(List<Integer> numberList) {
        return numberList.stream()
                .allMatch(num -> num>=MINIMUM_NUM_IN_RANGE && num<=MAXIMUM_NUM_IN_RANGE);
    }

    private static boolean isDistinct(List<Integer> numberList) {
        return numberList.stream()
                .distinct()
                .count() == LIST_SIZE;
    }

    private static List<Integer> StringToList(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

}
