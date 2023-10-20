package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Const.FIXED_THREE_CIPHERS;

public class Computer {
    private final List<Integer> threeNumbers = new ArrayList<>();

    public void generateThreeNumbers() {
        while (threeNumbers.size() < FIXED_THREE_CIPHERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeNumbers.contains(randomNumber)) {
                threeNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getThreeNumbers() {
        return threeNumbers;
    }
}
