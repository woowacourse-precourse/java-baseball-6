package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.AbstractBooleanArrayAssert;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private final List<Integer> pickedNumbers;

    public RandomNumberGenerator() {
        this.pickedNumbers = new ArrayList<>();
    }

    @Override
    public int generate() {
        int number;
        do {
            number = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        } while (pickedNumbers.contains(number));
        pickedNumbers.add(number);
        return number;
    }
}
