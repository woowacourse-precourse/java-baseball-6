package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    private static final Integer RANDOM_NUMBER_SIZE = 3;
    private static final Integer RANDOM_NUMBER_MIN_RANGE = 1;
    private static final Integer RANDOM_NUMBER_MAX_RANGE = 9;
    private List<Integer> RandomNumber;

    public Computer() {
        RandomNumber = generateListOf3RandomNumber();
    }

    private int chooseRandomNumber() {
        return pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE);
    }

    private List<Integer> generateListOf3RandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();

        for (int i = 0; i < RANDOM_NUMBER_SIZE; i++) {
            int number = chooseRandomNumber();

            if (!isDuplicatedNumber(randomNumberList, number)) {
                i--;
                continue;
            }
            randomNumberList.add(number);
        }

        return randomNumberList;
    }

    public List<Integer> loadRandomNumber() {
        return RandomNumber;
    }

    private boolean isDuplicatedNumber(final List<Integer> randomNumberList, final int number) {
        return randomNumberList.contains(number);
    }
}
