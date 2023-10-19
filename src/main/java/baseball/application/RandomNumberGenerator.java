package baseball.application;

import baseball.domain.Number;
import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.controller.GameConstants.*;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public Numbers generateNumbers() {
        List<Number> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_SIZE.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber());
            if (!numbers.contains(new Number(randomNumber))) {
                numbers.add(new Number(randomNumber));
            }
        }
        return new Numbers(numbers);
    }
}
