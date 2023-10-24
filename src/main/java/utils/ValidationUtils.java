package utils;

import baseball.domain.EndOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationUtils {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final List<Integer> END_OPTION = List.of(1, 2);

    private ValidationUtils() {
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isSingleNumber(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    public static boolean isOtherNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }

    public static boolean isEndOptionNumber(int number) {
        return EndOption.isContain(number);
    }
}
