package baseball.utils;

import static baseball.constants.DigitConstants.NUMBER_RANGE_MAX;
import static baseball.constants.DigitConstants.NUMBER_RANGE_MIN;
import static baseball.constants.DigitConstants.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class RandomNumberGenerator {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
