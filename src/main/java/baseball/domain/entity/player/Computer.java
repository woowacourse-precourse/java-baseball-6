package baseball.domain.entity.player;

import baseball.domain.entity.Numbers;

public class Computer implements Player {

    private final Numbers numbers;

    private Computer(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Computer of(Numbers numbers) {
        return new Computer(numbers);
    }

    @Override
    public Numbers getNumbers() {
        return numbers;
    }
}
