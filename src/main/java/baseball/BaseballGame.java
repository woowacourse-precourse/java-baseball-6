package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int NUMBER_SIZE = 3;
    private final List<Integer> numbers;

    public BaseballGame() {
        numbers = new ArrayList<>();
        setNumber();
    }

    private void setNumber(){
        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
