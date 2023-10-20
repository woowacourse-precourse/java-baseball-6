package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int NUM_DIGITS = 3; // 타겟 넘버 자릿 수
    private List<Integer> targetNumber;

    public Computer() {
        targetNumber = new ArrayList<>();
        generateTargetNumber();
    }

    private void generateTargetNumber() {
        while (targetNumber.size() < NUM_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }
    }
}
