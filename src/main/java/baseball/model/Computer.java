package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final static int COUNT = 3;
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 9;
    private List<Integer> numbers;

    public void prepareGame() {
        this.numbers = new ArrayList<>();
        while (numbers.size() < COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
