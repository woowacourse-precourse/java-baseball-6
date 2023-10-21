package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int NUMBER_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }
}
