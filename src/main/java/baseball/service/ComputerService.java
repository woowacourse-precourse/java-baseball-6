package baseball.service;

import baseball.constant.NumberConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    public List<Integer> createNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NumberConstant.INPUT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NumberConstant.MIN_NUMBER, NumberConstant.MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
