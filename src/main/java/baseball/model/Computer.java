package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> hiddenNumber = new ArrayList<>();

    public Computer() {
        initializeHiddenNumber();
    }

    public List<Integer> getHiddenNumber() {
        return hiddenNumber;
    }

    private void initializeHiddenNumber() {
        boolean[] doesExist = new boolean[10];
        while (hiddenNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            checkDuplicateAndAddToList(doesExist, randomNumber);
        }
    }

    private void checkDuplicateAndAddToList(boolean[] doesExist, int randomNumber) {
        if (!doesExist[randomNumber]) {
            hiddenNumber.add(randomNumber);
            doesExist[randomNumber] = true;
        }
    }

    public void resetForNewGame() {
        hiddenNumber.clear();
        initializeHiddenNumber();
    }
}
