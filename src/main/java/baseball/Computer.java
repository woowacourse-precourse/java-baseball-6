package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = new ArrayList<>();
    }

    public void createComputerNumber(int length) {
        while (computerNumber.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public int get(int idx) {
        return computerNumber.get(idx);
    }

    public boolean contains(int value) {
        if (computerNumber.contains(value)) {
            return true;
        } else {
            return false;
        }
    }
}
