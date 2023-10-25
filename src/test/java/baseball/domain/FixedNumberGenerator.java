package baseball.domain;

import baseball.util.NumberGenerator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {
    private final Deque<Integer> fixedNumbers;

    public FixedNumberGenerator(List<Integer> fixedNumbers) {
        this.fixedNumbers = new ArrayDeque<>(fixedNumbers);
    }

    @Override
    public int createNumber() {
        return fixedNumbers.remove();
    }
}
