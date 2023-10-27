package baseball.domain;

import static baseball.domain.Constant.MAXIMUM_BALL_NUMBER;
import static baseball.domain.Constant.MININUM_BALL_NUMBER;
import static baseball.domain.ErrorMessage.RANDOM_NUMBER_IS_DUPLICATED;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

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
            number = Randoms.pickNumberInRange(MININUM_BALL_NUMBER, MAXIMUM_BALL_NUMBER);
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
