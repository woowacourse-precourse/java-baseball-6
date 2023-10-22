package baseball.domain;

import baseball.util.NumberGenerator;
import java.util.Deque;

public class FixedNumberGenerator implements NumberGenerator {
    private final Deque<Integer> fixedNumbers;

    public FixedNumberGenerator(Deque<Integer> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public int createNumber() {
        return fixedNumbers.remove();
    }
}
