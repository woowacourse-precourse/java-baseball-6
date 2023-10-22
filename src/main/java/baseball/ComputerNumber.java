package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final List<Integer> number;

    public ComputerNumber() {
        this.number = new ArrayList<>();
    }

    public void createComputerNumber() {
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

    public int get(int index) {
        return number.get(index);
    }

    public boolean contains(int value) {
        if (number.contains(value)) {
            return true;
        } else {
            return false;
        }
    }
}
