package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumbers {

    private static final int START_RANGE_NUMBER = 1;
    private static final int END_RANGE_NUMBER = 9;
    private final List<Integer> numbers = new ArrayList<>();
    
    public void init() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE_NUMBER,END_RANGE_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
