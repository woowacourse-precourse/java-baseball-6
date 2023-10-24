package baseball;

import baseball.utils.Util;
import java.util.List;

public class Number {

    private final List<Integer> numbers;

    private Number(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Number from(String input) {
        List<Integer> numbers = Util.stringToInt(input);
        return new Number(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
