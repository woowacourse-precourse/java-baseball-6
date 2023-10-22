package baseball.util;

import baseball.domain.BaseballNumbers;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    static List<Integer> numbers = new ArrayList<>();
    public BaseballNumbers parseStringToBaseballNumbers(String input) {
        for (int i = 0; i < input.length(); i++) {
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return new BaseballNumbers(numbers);
    }
}
