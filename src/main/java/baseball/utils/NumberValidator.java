package baseball.utils;

import java.util.HashSet;
import java.util.List;

public class NumberValidator {
    public static void isValid(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자가 3개가 아닙니다.");
        }
        HashSet<Integer> hashSet = new HashSet<>(numbers);

        if(numbers.size() != hashSet.size()){
            throw new IllegalArgumentException("서로 다른 숫자가 아닙니다.");
        }
    }
}
