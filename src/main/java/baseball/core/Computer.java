package baseball.core;

import static baseball.constant.NumberConstant.INPUT_LENGTH;
import static baseball.constant.NumberConstant.MAXIMUM_RANGE_NUMBER;
import static baseball.constant.NumberConstant.MINIMUM_RANGE_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANGE_NUMBER, MAXIMUM_RANGE_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
