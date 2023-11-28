package baseball.model.pitcher;

import baseball.model.vo.BaseballNumber;
import java.util.List;

public class TestPitcher implements Pitcher {

    @Override
    public BaseballNumber generate() {
        List<Integer> testNumber = List.of(1, 2, 3);
        return BaseballNumber.of(testNumber);
    }
}
