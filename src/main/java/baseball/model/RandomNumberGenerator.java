package baseball.model;

import static baseball.Constants.MAX_NUM;
import static baseball.Constants.MIN_NUM;
import static baseball.Constants.NUMBER_COUNTS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> pickedNumbers = new ArrayList<>();

        while (pickedNumbers.size() < NUMBER_COUNTS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!pickedNumbers.contains(randomNumber)) {
                pickedNumbers.add(randomNumber);
            }
        }

        return pickedNumbers;
    }
}
