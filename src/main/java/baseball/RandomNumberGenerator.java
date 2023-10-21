package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class RandomNumberGenerator {

    public RandomNumberGenerator() {
    }

    public List<Integer> createNumber(int digits) {
        return Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(digits)
                .toList();
    }
}
