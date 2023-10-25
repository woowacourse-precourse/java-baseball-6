package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_SIZE = 3;

    List<Integer> number = new ArrayList<>();

    Computer() {
        while (number.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumber() {
        return this.number;
    }
}
