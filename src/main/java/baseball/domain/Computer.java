package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MAX_SIZE = 3;
    private static final int LOWER_RANGE = 1;
    private static final int UPPER_RANGE = 9;
    private final List<Integer> computer;

    public Computer() {
        this.computer = createRandomNumbers();
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(LOWER_RANGE, UPPER_RANGE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;

    }

    public List<Integer> getComputer() {
        return this.computer;
    }


}
