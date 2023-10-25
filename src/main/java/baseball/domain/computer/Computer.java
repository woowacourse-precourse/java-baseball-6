package baseball.domain.computer;

import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {

    }

    public void updateNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getIndexNumbers(int i) {
        return this.numbers.get(i);
    }
}
