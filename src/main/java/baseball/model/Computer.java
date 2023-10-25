package baseball.model;

public class Computer {

    private final Numbers numbers;

    public Computer() {
        this.numbers = Numbers.random();
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
