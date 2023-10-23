package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> number;

    public Computer () {
        number = new ArrayList<>();
        setNumber();
    }

    public void setNumber() {
        resetNumber();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
                System.out.print(randomNumber);
            }
        }
        System.out.println();
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void resetNumber() {
        number.clear();
    }
}
