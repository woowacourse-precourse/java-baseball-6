package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    private List<Integer> digits;

    public Baseball(int inputNumber) {
        digits = new ArrayList<>(3);
        digits.add(inputNumber / 100);
        digits.add((inputNumber / 10) % 10);
        digits.add(inputNumber % 10);
    }

    private Baseball(List<Integer> computer) {
        digits = new ArrayList<>(computer);
    }

    public static Baseball createAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
