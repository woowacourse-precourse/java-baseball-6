package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Const.FIXED_THREE_CIPHERS;

public class Computer {
    private final List<Integer> threeNumbers = new ArrayList<>();

    public void generateThreeNumbers() {
        if (threeNumbers.size() > 0) flushNumbers();

        while (threeNumbers.size() < FIXED_THREE_CIPHERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeNumbers.contains(randomNumber)) {
                threeNumbers.add(randomNumber);
            }
        }
    }

    private void flushNumbers() {
        threeNumbers.clear();
    }

    public List<Integer> getThreeNumbers() {
        return threeNumbers;
    }
}
