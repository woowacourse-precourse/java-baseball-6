package baseball.controller;

import static baseball.model.NumberRule.NUMBER_RANGE_END;
import static baseball.model.NumberRule.NUMBER_RANGE_START;
import static baseball.model.NumberRule.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public List<Integer> generateRandomNum() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_SIZE.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START.getNumber(), NUMBER_RANGE_END.getNumber());
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
