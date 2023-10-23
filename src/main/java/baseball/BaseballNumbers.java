package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

    private static final int SIZE = 3;
    private final List<BaseballNumber> numbers;

    public static BaseballNumbers fromInput(String input) {
        List<BaseballNumber> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(new BaseballNumber(Character.getNumericValue(c)));
        }
        return new BaseballNumbers(numbers);
    }

    public BaseballNumbers(List<BaseballNumber> numbers) {
        validateSize(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateSize(List<BaseballNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("숫자의 크기는 " + SIZE + "을 넘기면 안됩니다.");
        }
    }

    public BaseballNumber getNumberAt(int index) {
        return numbers.get(index);
    }
}
