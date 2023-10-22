package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final int BASEBALL_GAME_START_NUMBER = 1;
    private static final int BASEBALL_GAME_END_NUMBER = 9;

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int index = 0; index < BASEBALL_GAME_NUMBER_LENGTH; index++) {
            randomNumbers.add(generateRandomNumber(randomNumbers));
        }

        return randomNumbers;
    }

    private int generateRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_GAME_START_NUMBER, BASEBALL_GAME_END_NUMBER);

            if (!randomNumbers.contains(randomNumber)) {
                return randomNumber;
            }
        }
    }
}
