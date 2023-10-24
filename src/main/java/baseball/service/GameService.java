package baseball.service;

import static baseball.domain.Constants.NUMBER_OF_BASEBALL;

import baseball.domain.BaseballNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    public BaseballNumbers generateComputerNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_OF_BASEBALL) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return new BaseballNumbers(numbers);
    }
}
