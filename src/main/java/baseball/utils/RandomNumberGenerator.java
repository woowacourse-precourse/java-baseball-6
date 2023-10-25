package baseball.utils;

import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class RandomNumberGenerator {

    private static final int NUMBER_SIZE = 3;
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 9;

    public static Numbers generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return Numbers.from(numbers);
    }
}
