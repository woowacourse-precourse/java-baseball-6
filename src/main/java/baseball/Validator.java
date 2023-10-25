package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < GetRandomNum.MIN_NUM || number > GetRandomNum.MAX_NUM) {
                throw new IllegalArgumentException();
            }
        }
        if(numbers.size() != GetRandomNum.ARRAY_SIZE) {
            throw new IllegalArgumentException();
        }
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if(setNumbers.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }
}
