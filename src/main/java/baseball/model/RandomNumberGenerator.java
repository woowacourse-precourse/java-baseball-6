package baseball.model;

import static baseball.NumericRange.COUNT;
import static baseball.NumericRange.MAX_VALUE;
import static baseball.NumericRange.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> pickedNumbers = new ArrayList<>();

        while (pickedNumbers.size() < COUNT.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE.getNumber(),
                MAX_VALUE.getNumber());
            if (!pickedNumbers.contains(randomNumber)) {
                pickedNumbers.add(randomNumber);
            }
        }

        return pickedNumbers;
    }
}
