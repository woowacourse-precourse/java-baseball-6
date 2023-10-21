package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int LENGTH_RANDOMNUMBERS = 3;
    private final List<Integer> randomNumbers;

    public Computer() {
        randomNumbers = new ArrayList<>();

        initializeRandomNumbers();
    }

    private void initializeRandomNumbers() {
        while (randomNumbers.size() < LENGTH_RANDOMNUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            addDistinctRandomNumberToRandomNumbers(randomNumber);
        }
    }

    private void addDistinctRandomNumberToRandomNumbers(int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
