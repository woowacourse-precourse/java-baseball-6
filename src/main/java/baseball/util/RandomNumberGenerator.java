package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberGenerator {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int REPEAT_COUNT = 3;

    public static List<Integer> generate() {
        return Stream.generate(() -> Randoms.pickNumberInRange(MIN, MAX))
                .distinct()
                .limit(REPEAT_COUNT)
                .collect(Collectors.toList());
    }
}
