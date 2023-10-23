package baseball.service;

import static baseball.util.Constants.*;

import baseball.util.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class ComputerService {
    private final ArrayList<Integer> randomNumbers;

    public ComputerService() {
        randomNumbers = generateRandomNumbers();
    }

    public ArrayList<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private static ArrayList<Integer> generateRandomNumbers() {
        ArrayList<Integer> RandomNumbers = new ArrayList<>();
        while (RandomNumbers.size() < Constants.NUMBERS_SIZE) {
            int num = Randoms.pickNumberInRange(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE);
            if (!RandomNumbers.contains(num)) {
                RandomNumbers.add(num);
            }
        }
        return RandomNumbers;
    }
}

