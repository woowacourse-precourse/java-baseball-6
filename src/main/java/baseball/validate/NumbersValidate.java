package baseball.validate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersValidate {

    public static void isAllNumbers(String numbers) {
        Arrays.stream(numbers.split(""))
            .map(NumberValidate::isNumber).toList();
    }
    public static boolean isNumberNotDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbers.size() == numbersSet.size();
    }
}
