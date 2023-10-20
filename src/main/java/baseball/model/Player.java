package baseball.model;

import java.util.List;

public class Player {
    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
