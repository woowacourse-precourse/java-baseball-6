package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    List<Integer> number;

    public Computer() {
        this.number = new ArrayList<>();
    }

    public void makeNumber() {

        number.clear();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

    public int getBall(int index) {
        return number.get(index);
    }

    public boolean containsBall(int ball) {
        return number.contains(ball);
    }
}
