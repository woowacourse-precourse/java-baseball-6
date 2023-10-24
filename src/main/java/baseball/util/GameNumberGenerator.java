package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.Constants.*;

public class GameNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> getRandomNumber() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
        return randomNums;
    }
}
