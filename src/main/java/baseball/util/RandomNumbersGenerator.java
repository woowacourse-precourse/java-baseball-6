package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.NumberConstants.MAX_NUMBER;
import static baseball.constant.NumberConstants.MIN_NUMBER;
import static baseball.constant.NumberConstants.NUMBER_SIZE;

public class RandomNumbersGenerator {

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER.getValue(),
                    MAX_NUMBER.getValue());
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
