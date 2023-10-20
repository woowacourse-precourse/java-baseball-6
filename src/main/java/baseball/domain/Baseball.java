package baseball.domain;

import static baseball.common.Constants.DIGIT_COUNT;
import static baseball.common.Constants.MAXIMUM_DIGIT_NUMBER;
import static baseball.common.Constants.MINIMUM_DIGIT_NUMBER;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    private List<Integer> digits;

    public Baseball(int number) {
        digits = new ArrayList<>(DIGIT_COUNT);
        digits.add(number / 100);
        digits.add((number / 10) % 10);
        digits.add(number % 10);
    }

    private Baseball(List<Integer> computer) {
        digits = new ArrayList<>(computer);
    }

    public static Baseball createAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_DIGIT_NUMBER, MAXIMUM_DIGIT_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new Baseball(computer);
    }

    public List<Integer> getDigits() {
        return digits;
    }
}
