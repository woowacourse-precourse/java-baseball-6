package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String targetNumber;

    private void generateTargetNumber() {
        StringBuilder targetNumber = new StringBuilder();
        List<Integer> targetNumbers = new ArrayList<>();
        while (targetNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
                targetNumber.append(randomNumber);
            }
        }

        this.targetNumber = targetNumber.toString();
    }
}
