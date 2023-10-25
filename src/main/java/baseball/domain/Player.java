package baseball.domain;

import java.util.List;

public class Player {

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Player from(List<Integer> numbers) {
        return new Player(numbers);
    }

    public int getNumberOf(int idx) {
        return numbers.get(idx);
    }
}
