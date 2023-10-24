package baseball.fixture;

import baseball.model.Number;

public class NumberFixture {

    public static Number createNumber(final int input) {
        return new Number(input);
    }
}
