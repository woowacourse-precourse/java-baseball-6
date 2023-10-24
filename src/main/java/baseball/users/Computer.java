package baseball.users;

import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer(List<Integer> computerNumbers) {
        this.numbers = computerNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
