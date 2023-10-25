package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public record Computer() {
    private static final int LENGTH_RANDOM_NUMBERS = 3;

    private static final List<Integer> randomNumbers = new ArrayList<>();

    public void initializeRandomNumbers() {
        randomNumbers.clear();

        while (randomNumbers.size() < LENGTH_RANDOM_NUMBERS) {
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
