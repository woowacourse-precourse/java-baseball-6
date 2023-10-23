package baseball.common;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtility {

    public static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < NumberConstants.NUMBER_LENGTH.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(NumberConstants.NUMBER_RANGE_MIN.getValue(), NumberConstants.NUMBER_RANGE_MAX.getValue());
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
