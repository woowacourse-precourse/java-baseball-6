package baseball.domain;

public class Computer {

    private final BaseballGameNumbers numbers;

    public Computer(BaseballGameNumbers numbers) {
        this.numbers = numbers;
    }

    public BaseballGameNumbers getNumbers() {
        return this.numbers;
    }

}
