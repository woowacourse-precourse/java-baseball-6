package baseball.generator;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List<Integer> createRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
