package baseball.domain;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public BaseballNumber generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new BaseballNumber(numbers);
    }
}