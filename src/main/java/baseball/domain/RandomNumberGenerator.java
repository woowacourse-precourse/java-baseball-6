package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public BaseballNumber generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int random = Randoms.pickNumberInRange(1,9);
            if (!numbers.contains(random))
                numbers.add(random);
        }
        return new BaseballNumber(numbers);
    }
}
