package baseball.domain;

import java.util.stream.Stream;

public class FixedBaseballNumbersGenerator implements BaseballNumbersGenerator {
    @Override
    public BaseballNumbers generate() {
        return new BaseballNumbers(Stream.of(7, 1, 3).map(BaseballNumber::new).toList());
    }
}
