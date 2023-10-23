package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Numbers numbers;

    public Player(String input) {
        this.numbers = createPlayerNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    private Numbers createPlayerNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(input.charAt(i) - '0');
        }
        return new Numbers(numbers);
    }
}
