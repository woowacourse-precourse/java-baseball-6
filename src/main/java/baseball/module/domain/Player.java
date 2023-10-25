package baseball.module.domain;

import java.util.Iterator;
import java.util.List;

public class Player {

    private final List<Integer> numbers;

    private Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Player input(List<Integer> numbers) {
        return new Player(numbers);
    }

    public Iterator<Integer> getPlayerNumbers() {
        return numbers.iterator();
    }
}