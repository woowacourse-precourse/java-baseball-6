package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.GameConstants.*;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_SIZE.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber());
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
