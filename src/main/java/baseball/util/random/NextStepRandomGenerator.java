package baseball.util.random;

import baseball.application.random.RandomGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NextStepRandomGenerator implements RandomGenerator {

    public List<Integer> pickUniqueNumbersInRange(Range range, int count) {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < count) {
            int number = Randoms.pickNumberInRange(range.startInclusive(), range.endInclusive());
            numbers.add(number);
        }
        return new ArrayList<>(numbers);
    }
}
