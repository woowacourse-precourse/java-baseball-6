package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class SystemRandomCreator implements RandomCreator {

    private static final SystemRandomCreator instance = new SystemRandomCreator();
    public static final int NUMBER_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static SystemRandomCreator getInstance() {
        return instance;
    }

    @Override
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    @Override
    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_SIZE) {
            addUniqueNumber(randomNumbers, createRandomNumber());
        }
        return randomNumbers;
    }

    private void addUniqueNumber(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }
}
