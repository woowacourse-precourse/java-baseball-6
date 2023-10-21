package baseball.model.service;

import static baseball.model.constants.Constant.NUMBER_MAX_VALUE;
import static baseball.model.constants.Constant.NUMBER_MIN_VALUE;
import static baseball.model.constants.Constant.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberImpl implements ComputerNumber {
    @Override
    public List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
