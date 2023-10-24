package baseball;

import java.util.List;

public class Ball {
    private final List<Integer> numbers;

    public Ball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
