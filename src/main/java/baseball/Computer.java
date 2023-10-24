package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    private static final Integer RANDOM_NUMBER_SIZE = 3;
    private static final Integer RANDOM_NUMBER_MIN_RANGE = 1;
    private static final Integer RANDOM_NUMBER_MAX_RANGE = 9;
    private final List<Integer> randomNumber;

    public Computer() {
        randomNumber = loadList();
    }

    public List<Integer> speakNumbers() {
        return randomNumber;
    }

    private List<Integer> loadList() {
        List<Integer> randomNumberList = new ArrayList<>();

        for (int i = 0; i < RANDOM_NUMBER_SIZE; i++) {
            int number = chooseRandomNumber();

            if (isDuplicatedNumber(randomNumberList, number)) {
                i--;
                continue;
            }
            randomNumberList.add(number);
        }

        return randomNumberList;
    }

    private int chooseRandomNumber() {
        return pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE);
    }

    private boolean isDuplicatedNumber(final List<Integer> randomNumberList, final int number) {
        return randomNumberList.contains(number);
    }
}
