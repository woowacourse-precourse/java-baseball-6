package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Game.NUM_DIGITS;


public class Computer {
    private List<Integer> targetNumber;

    public Computer() {
        targetNumber = new ArrayList<>();
        generateTargetNumber();
    }

    public void generateTargetNumber() {
        while (targetNumber.size() < NUM_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getTargetNumber() {
        return targetNumber;
    }
}
