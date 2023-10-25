package baseball;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
