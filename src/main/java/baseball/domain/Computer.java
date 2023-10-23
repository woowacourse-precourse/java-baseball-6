package baseball.domain;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int NUMBER_SIZE = Constant.NUMBER_SIZE.getConstant();

    public List<Integer> createNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
