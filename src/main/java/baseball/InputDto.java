package baseball;

import java.util.stream.Collectors;
import java.util.List;

public class InputDto {

    public static void validateNumber(String number) {
        if (number.length() != 3 || hasDuplicateCharacters(number) || !isNumeric(number)) {
            throw new IllegalArgumentException("입력 값은 서로 다른 3자리의 숫자여야 합니다.");
        }
    }

    private static boolean hasDuplicateCharacters(String number) {
        return number.chars().distinct().count() != 3;
    }

    private static boolean isNumeric(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    public static List<Integer> convertToNumberList(String input) {
        return input.chars()
                    .mapToObj(Character::getNumericValue)
                    .collect(Collectors.toList());
    }
}
