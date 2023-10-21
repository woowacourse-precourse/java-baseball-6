package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class RandomNumber {

    private static final int MIN_DIGIT = Digit.MIN_VALUE;
    private static final int MAX_DIGIT = Digit.MAX_VALUE;
    private static final int NUMBER_LENGTH = Number.NUMBER_LENGTH;

    private final Supplier<Integer> randomValue;

    RandomNumber(Supplier<Integer> randomValue) {
        this.randomValue = Objects.requireNonNull(randomValue);
    }

    public static RandomNumber create() {
        return new RandomNumber(() -> Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT));
    }

    public Number generate() {
        List<Digit> values = Stream.iterate(generateRandomDigit(), digit -> generateRandomDigit())
                .distinct().limit(NUMBER_LENGTH)
                .toList();

        return Number.from(values);
    }

    private Digit generateRandomDigit() {
        int value = randomValue.get();
        return Digit.from(value);
    }

}
