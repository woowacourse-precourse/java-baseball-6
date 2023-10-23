package baseball.util.random;

import baseball.application.random.RandomGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NextStepRandomGenerator implements RandomGenerator {

    public List<Integer> pickUniqueNumbersInRange(Range range, int count) {
        return Randoms.pickUniqueNumbersInRange(
            range.startInclusive(), range.endInclusive(), count);
    }
}
