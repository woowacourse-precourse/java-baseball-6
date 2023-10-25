package baseball.numbers;

import java.util.List;

public abstract class NumbersGenerator {
    public List<Integer> generate() {
        Numbers numbers = new Numbers(createNumbers());
        return numbers.getNumbers();
    }

    abstract List<Integer> createNumbers();
}
