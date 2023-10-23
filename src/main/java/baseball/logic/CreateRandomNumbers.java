package baseball.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateRandomNumbers {
    public static final int RANDOM_NUMBER_MAX_LENGTH = 3;
    public static final int RANDOM_NUMBER_RANGE_START = 1;
    public static final int RANDOM_NUMBER_RANGE_END = 9;

    List<Integer> answerNumbers;

    public CreateRandomNumbers() {
        this.answerNumbers = setRandomNumbers();
    }

    public List<Integer> setRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < RANDOM_NUMBER_MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
