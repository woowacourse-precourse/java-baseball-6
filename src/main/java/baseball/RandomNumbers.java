package baseball;

import static baseball.InputRange.END_RANDOM_RANGE;
import static baseball.InputRange.START_RANDOM_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private final List<Integer> randomNumbers = new ArrayList<>();
    private static final int MAX_RANDOM_NUMBER_SIZE = 3;

    public RandomNumbers() {
        randomNumbersGenerate();
    }

    public int getDigit(int index) {
        return randomNumbers.get(index);
    }

    public List<Integer> getRandomNumbers() {
        return this.randomNumbers;
    }

    private void randomNumberClear() {
        if (randomNumbers.size() >= MAX_RANDOM_NUMBER_SIZE) {
            randomNumbers.clear();
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_RANGE.getValue(), END_RANDOM_RANGE.getValue());
    }

    public void randomNumbersGenerate() {
        randomNumberClear();

        while (randomNumbers.size() < MAX_RANDOM_NUMBER_SIZE) {
            int randomNumber = getRandomNumber();
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }
}
