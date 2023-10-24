package baseball.counter;

import java.util.Optional;

public class CounterValidator {
    public static Optional<Integer> isValidCount(int count) {
        return Optional.of(count).filter(cnt -> cnt != 0);
    }
}
