package baseball.domain;

public class Computer {
    private final Numbers numbers;

    public Computer(final Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
