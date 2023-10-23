package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    private final List<Integer> numbers;

    private InputNumber(List<Integer> numbers) {
        if (this.isValid(numbers)) {
            this.numbers = numbers;
        } else {
            throw new IllegalArgumentException("유효하지 않은 입력 값 형식입니다.");
        }
    }

    public static InputNumber of(int input) {
        return new InputNumber(hundredsIntToList(input));
    }

    private static List<Integer> hundredsIntToList(int number) {
        List<Integer> result = new ArrayList<>();

        result.add(number / 100);
        result.add((number % 100) / 10);
        result.add(number % 10);

        return result;
    }

    private boolean isValid(List<Integer> numbers) {
        // 3자리가 아닌 경우, 0이 포함된 경우, 서로 다른 숫자가 아닌 경우 유효하지 않은 숫자
        return (numbers.size() == 3) && (!numbers.contains(0)) && (hasDuplicate(numbers));
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream().noneMatch(n -> numbers.indexOf(n) != numbers.lastIndexOf(n));
    }
}
