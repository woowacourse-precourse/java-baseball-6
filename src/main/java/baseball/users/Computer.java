package baseball.users;

import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer(List<Integer> computerNumbers) {
        this.numbers = computerNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void changeNumbers(List<Integer> computerNumbers) {
        this.numbers = computerNumbers;
    }
}
