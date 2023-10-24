package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private final List<Integer> seperatedNumbers;

    public Converter(String input) {
        seperatedNumbers = seperate(input);
    }

    private List<Integer> seperate(final String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    public List<Integer> getSeperatedNumbers() {
        return seperatedNumbers;
    }
}
