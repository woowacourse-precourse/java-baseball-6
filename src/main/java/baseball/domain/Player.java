package baseball.domain;

import java.util.List;

public class Player {

    private final List<Integer> numbers;

    private Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Player of(List<Integer> numbers) {
        return new Player(numbers);
    }

    public int getNumberOf(int index) {
        return numbers.get(index);
    }
}
