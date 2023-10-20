package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    Integer hundreds;
    Integer tens;
    Integer ones;

    public Baseball(int inputNumber) {
        hundreds = inputNumber / 100;
        tens = (inputNumber / 10) % 10;
        ones = inputNumber % 10;
    }

    private Baseball(int hundreds, int tens, int ones) {
        this.hundreds = hundreds;
        this.tens = tens;
        this.ones = ones;
    }

    public static Baseball createAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new Baseball(computer.get(0), computer.get(1), computer.get(2));
    }
}
