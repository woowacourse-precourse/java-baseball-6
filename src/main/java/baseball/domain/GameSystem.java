package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private final List<Integer> systemBaseBallNumber;

    public GameSystem() {
        this.systemBaseBallNumber = initBaseBallNumber();
    }

    public List<Integer> getSystemBaseBallNumber() {
        return systemBaseBallNumber;
    }

    private List<Integer> initBaseBallNumber() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }

        return number;
    }
}
