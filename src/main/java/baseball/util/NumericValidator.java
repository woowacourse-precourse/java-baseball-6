package baseball.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumericValidator {

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 자릿수 오류");
        } else if (!isDifferentNumber(numbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 중복 오류");
        } else if (!isBetween1And9(numbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 범위 오류");
        }
    }

    // 서로 다른 숫자인지 검사
    private boolean isDifferentNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            set.add(numbers.get(i));
        }
        return set.size() == 3;
    }

    // 1 ~ 9 사이의 숫자인지 검사
    private boolean isBetween1And9(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if(!(numbers.get(i) >= 1 && numbers.get(i) <= 9)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> converStringToList(String inputNumber) {
        int[] intArray = Arrays.stream(inputNumber.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Arrays.stream(intArray).boxed().collect(Collectors.toList());
    }
}
