package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> Number = new ArrayList<>(3);

    // Constructor Set Random value
    public Computer() {
        this.setNumber();
    }

    // Set Random Number If New Game Start.
    public void setNumber() {
        for (int numberIdx = 0; numberIdx < 3; numberIdx++) {

            int randomNumber = 0;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (Number.contains(randomNumber));
            Number.set(numberIdx, randomNumber);
        }
    }

    public ReturnType Confirm(List<Integer> Human) {
        return null;
    }
}
