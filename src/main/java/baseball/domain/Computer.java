package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Const.*;

public class Computer {
    private final List<Integer> threeNumbers = new ArrayList<>();

    public void generateThreeNumbers() {
        if (threeNumbers.size() > 0) flushNumbers();

        while (threeNumbers.size() < FIXED_ANSWER_CIPHERS) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER);
            if (!threeNumbers.contains(randomNumber)) threeNumbers.add(randomNumber);
        }
    }

    private void flushNumbers() {
        threeNumbers.clear();
    }

    public boolean isStrike(int number, int index) {
        return number == threeNumbers.get(index);
    }

    public boolean isBall(int number, int index) {
        return !isStrike(number, index) && threeNumbers.contains(number);
    }
}