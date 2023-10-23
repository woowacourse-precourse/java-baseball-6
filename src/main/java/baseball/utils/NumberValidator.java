package baseball.utils;

import java.util.HashSet;
import java.util.List;

public class NumberValidator {
    public static boolean isValid(List<Integer> numbers) {
        if (numbers.size() != 3) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>(numbers);

        return numbers.size() == hashSet.size();
    }
}
