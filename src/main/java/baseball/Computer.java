package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    ArrayList<Integer> numbers = new ArrayList<>();

    public void selectNumber() {
        while (this.numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.numbers.contains(randomNumber)) {
                this.numbers.add(randomNumber);
            }
        }
    }
}
