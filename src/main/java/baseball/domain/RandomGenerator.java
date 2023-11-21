package baseball.domain;

import baseball.global.Const;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private static final Integer LIMIT_COUNT = 3;

    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < LIMIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Const.MINIMUM_VALUE, Const.MAXIMUM_VALUE);

            if (hasUniqueNumber(numbers, randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static boolean hasUniqueNumber(List<Integer> numbers, int randomNumber) {
        return !numbers.contains(randomNumber);
    }
}