package baseball.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersValidate {
    public static boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == 3;
    }

    public static boolean isNumberNotDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbers.size() == numbersSet.size();
    }

    public static boolean isNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(!NumberValidate.isInRange(number)) return false;
        }
        return true;
    }
}
