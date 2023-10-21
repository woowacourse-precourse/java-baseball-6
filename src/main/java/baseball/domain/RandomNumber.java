package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class RandomNumber {

    private static final int MIN_DIGIT = Digit.MIN_VALUE;
    private static final int MAX_DIGIT = Digit.MAX_VALUE;
    private static final int NUMBER_LENGTH = Number.NUMBER_LENGTH;

    private RandomNumber() {
    }

    public static Number generate() {
        List<Digit> values = Stream.iterate(generateRandomDigit(), digit -> generateRandomDigit())
                .distinct().limit(NUMBER_LENGTH)
                .toList();

        return Number.from(values);
    }

    private static Digit generateRandomDigit() {
        int value = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
        return Digit.from(value);
    }

}
