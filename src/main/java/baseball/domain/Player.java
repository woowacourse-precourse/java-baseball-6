package baseball.domain;

import java.util.stream.Collectors;

public class Player {
    private final Numbers numbers;
    private Player(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return Numbers.of(this.numbers.getValue().stream().map(number -> number.getValue())
                .collect(Collectors.toList()));
    }
    public static Player of(final Numbers numbers) {
        return new Player(numbers);
    }
}
