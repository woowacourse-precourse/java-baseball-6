package baseball.model;

import java.util.Collections;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player() {
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
