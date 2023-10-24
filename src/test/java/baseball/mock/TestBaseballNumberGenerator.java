package baseball.mock;

import baseball.baseball.BaseballNumber;
import baseball.baseball.BaseballNumberGenerator;
import java.util.List;

public class TestBaseballNumberGenerator implements BaseballNumberGenerator {
    private final List<Integer> fixedNumbers;

    public TestBaseballNumberGenerator(List<Integer> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public BaseballNumber generate() {
        return new BaseballNumber(fixedNumbers);
    }
}
