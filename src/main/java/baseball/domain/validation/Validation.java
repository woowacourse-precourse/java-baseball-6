package baseball.domain.validation;

import java.util.HashSet;
import java.util.List;

public class Validation {


    public static final List<Integer> AVAIL_NUMBER = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

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
}
