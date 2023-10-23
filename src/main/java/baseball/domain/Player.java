package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final Numbers numbers;

    public Player(String input) {
        this.numbers = createPlayerNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    private Numbers createPlayerNumbers(String input) {
        List<Integer> numbers = input.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }
}
