package baseball.service;

import static baseball.util.Constants.*;
import baseball.util.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    private final List<Integer> randomNumbers;

    public ComputerService() {
        randomNumbers = generateRandomNumbers();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> RandomNumbers = new ArrayList<>();
        while (RandomNumbers.size() < Constants.NUMBERS_SIZE) {
            int num = Randoms.pickNumberInRange(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE);
            if (!RandomNumbers.contains(num)) {
                RandomNumbers.add(num);
            }
        }
        return RandomNumbers;
    }
}

