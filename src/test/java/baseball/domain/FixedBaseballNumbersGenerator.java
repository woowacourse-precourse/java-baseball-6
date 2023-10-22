package baseball.domain;

import java.util.stream.Stream;

public class FixedNumbersGenerator implements NumbersGenerator {
    @Override
    public BaseballNumbers generate() {
        return new BaseballNumbers(Stream.of(7, 1, 3).map(BaseballNumber::new).toList());
    }
}
