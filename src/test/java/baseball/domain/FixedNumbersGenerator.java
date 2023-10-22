package baseball.domain;

import java.util.List;

public class FixedNumbersGenerator implements NumbersGenerator {
    @Override
    public Numbers generate() {
        return new Numbers(List.of(7, 1, 3));
    }
}
