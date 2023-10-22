package baseball.util;

import java.util.List;

public class NumberUtil {

    protected NumberUtil() {

    }

    public static List<Integer> converStringToList(String numberString) {
        return numberString.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public static void validate(String number) {
        validateEmpty(number);
        validateLength(number);
        validateNumber(number);
        validateUnique(number);
        validateSign(number);
        validateRange(number);
    }

    protected static void validateEmpty(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    protected static void validateLength(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리이어야 합니다.");
        }
    }

    protected static void validateNumber(String number) {
        if (number.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("입력값은 정수이어야 합니다.");
        }
    }

    protected static void validateSign(String number) {
        if (number.charAt(0) == '-') {
            throw new IllegalArgumentException("입력값은 양의 정수이어야 합니다.");
        }
    }

    protected static void validateRange(String number) {
        if (number.chars().anyMatch(n -> n < '1' || n > '9')) {
            throw new IllegalArgumentException("입력되는 각 숫자는 1 이상 9 이하의 정수로 이루어져야 합니다.");
        }
    }

    protected static void validateUnique(String number) {
        if (number.chars()
                .distinct()
                .count() != number.length()) {
            throw new IllegalArgumentException("입력되는 각 숫자는 서로 다른 숫자이어야 합니다.");
        }
    }
}
