package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    private static final Integer RANDOM_NUMBER_MIN_RANGE = 1;
    private static final Integer RANDOM_NUMBER_MAX_RANGE = 9;
    private List<Integer> RandomNumber;

    public Computer(List<Integer> randomNumber) {
        RandomNumber = randomNumber;
    }

    private int chooseRandomNumber() {
        return pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE);
    }
}
