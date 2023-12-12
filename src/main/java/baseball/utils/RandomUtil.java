package baseball.utils;

import static baseball.utils.constants.IntegerConstants.*;

import baseball.domain.entity.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE_NUMBER.getValue(), MAX_RANGE_NUMBER.getValue());
    }

    public static Numbers createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBERS_SIZE.getValue()) {
            addUniqueNumber(randomNumbers, createRandomNumber());
        }
        return Numbers.of(randomNumbers);
    }

    private static void addUniqueNumber(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }
}
