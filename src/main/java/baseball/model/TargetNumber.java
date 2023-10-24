package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class TargetNumber {
    List<Integer> targetNumber;

    public List<Integer> getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber() {
        targetNumber = new ArrayList<>();
        while (targetNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }
    }
}
