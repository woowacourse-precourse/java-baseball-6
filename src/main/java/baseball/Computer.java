package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    private static final int INPUT_LENGTH = 3;
    private static final int BASEBALL_MIN_RANGE = 1;
    private static final int BASEBALL_MAX_RANGE = 9;

    int[] computerBaseBallNumber = new int[INPUT_LENGTH];

    public void generateComputerBaseBallNumber() {
        Set<Integer> randomNumberSet = new HashSet<>();

        while (randomNumberSet.size() < INPUT_LENGTH) {
            randomNumberSet.add(Randoms.pickNumberInRange(BASEBALL_MIN_RANGE, BASEBALL_MAX_RANGE));
        }

        Integer[] randomBaseBallNumber = randomNumberSet.toArray(new Integer[0]);
        for (int i = 0; i < INPUT_LENGTH; i++) {
            this.computerBaseBallNumber[i] = randomBaseBallNumber[i];
        }
    }
}
