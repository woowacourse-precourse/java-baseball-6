package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> hiddenNumber = new ArrayList<>();
    private final boolean[] doesExist = new boolean[10];

    public Computer() {
        initializeHiddenNumber();
    }

    public List<Integer> getHiddenNumber() {
        return hiddenNumber;
    }

    public void resetForNewGame() {
        resetDoesExist();
        hiddenNumber.clear();
        initializeHiddenNumber();
    }

    private void checkDuplicateAndAddToList(int randomNumber) {
        if (!doesExist[randomNumber]) {
            hiddenNumber.add(randomNumber);
            doesExist[randomNumber] = true;
        }
    }

    private void initializeHiddenNumber() {
        while (hiddenNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            checkDuplicateAndAddToList(randomNumber);
        }
    }

    private void resetDoesExist() {
        for (int i = 0; i < 10; i++) {
            doesExist[i] = false;
        }
    }
}
