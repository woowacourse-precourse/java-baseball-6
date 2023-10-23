package baseball.common;

import static baseball.common.Number.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtility {

    public static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < NUMBER_LENGTH.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_MIN.getValue(), NUMBER_RANGE_MAX.getValue());
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
