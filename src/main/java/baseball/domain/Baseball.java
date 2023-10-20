package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    private Integer hundreds;
    private Integer tens;
    private Integer ones;

    public Baseball(Integer inputNumber) {
        hundreds = inputNumber / 100;
        tens = (inputNumber / 10) % 10;
        ones = inputNumber % 10;
    }

    private Baseball(Integer hundreds, Integer tens, Integer ones) {
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
