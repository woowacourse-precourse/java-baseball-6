package baseball.domain.validation;

import java.util.HashSet;
import java.util.List;

public class Validation {


    public static final List<Integer> AVAIL_NUMBER = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    public static final String NUMBER_IS_NOT_AVAILABLE = "숫자만 입력해주세요.";
    public static final String NUMBER_LENGTH_IS_NOT_AVAILABLE = "세자리 숫자를 입력해주세요.";
    public static final String NUMBER_SHOULD_BE_NOT_DUPLICATE = "서로 다른 세자리 수를 입력해주세요.";
    public static final String NUMBER_MUST_BE_1_TO_9 = "1 부터 9 사이의 숫자만 입력 가능합니다.";

    public static boolean isDuplicate(List<Integer> number) {
        long count = number.stream()
                .distinct()
                .count();
        return count != number.size();
    }

    public static boolean isInteger(String number) {
        return number.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean isAvailRange(List<Integer> number) {
        return !new HashSet<>(AVAIL_NUMBER).containsAll(number);
    }

    public static boolean isAvailLength(List<Integer> number) {
        return number.size() != 3;
    }

    public static void validNumber(String stringNumber, List<Integer> stringToInteger) {
        if (!Validation.isInteger(stringNumber)) {
            throw new IllegalArgumentException(NUMBER_IS_NOT_AVAILABLE);
        } else if (Validation.isAvailLength(stringToInteger)) {
            throw new IllegalArgumentException(NUMBER_LENGTH_IS_NOT_AVAILABLE);
        } else if (Validation.isDuplicate(stringToInteger)) {
            throw new IllegalArgumentException(NUMBER_SHOULD_BE_NOT_DUPLICATE);
        } else if (Validation.isAvailRange(stringToInteger)) {
            throw new IllegalArgumentException(NUMBER_MUST_BE_1_TO_9);
        }
    }
}
