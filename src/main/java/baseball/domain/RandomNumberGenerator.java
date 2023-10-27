package baseball.domain;

import static baseball.domain.ErrorMessage.RANDOM_NUMBER_IS_DUPLICATED;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private final List<Integer> pickedNumbers;

    private RandomNumberGenerator() {
        this.pickedNumbers = new ArrayList<>();
    }

    public static NumberGenerator init() {
        return new RandomNumberGenerator();
    }

    @Override
    public int generate() {
        int number;
        do {
            number = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        } while (pickedNumbers.contains(number));
        validateDuplicates(number);
        pickedNumbers.add(number);
        return number;
    }

    private void validateDuplicates(int number) {
        if (hasDuplicates(number)) {
            throw new IllegalArgumentException(RANDOM_NUMBER_IS_DUPLICATED);
        }
    }

    private boolean hasDuplicates(int number) {
        return pickedNumbers.contains(number);
    }
}
