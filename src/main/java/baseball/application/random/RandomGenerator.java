package baseball.application.random;

import baseball.util.random.Range;
import java.util.List;

public interface RandomGenerator {

    List<Integer> pickUniqueNumbersInRange(Range range, int count);
}
