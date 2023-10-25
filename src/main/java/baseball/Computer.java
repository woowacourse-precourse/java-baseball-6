package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerSelectedNumber = new ArrayList<>(3);

    public Computer() {
    }

    public List computerNumberSelection() {
        while (computerSelectedNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerSelectedNumber.contains(randomNumber)) {
                computerSelectedNumber.add(randomNumber);
            }
        }
        return computerSelectedNumber;
    }
}