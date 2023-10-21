package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballModel {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private final List<Integer> numbers = new ArrayList<>();

    public void chooseRandomNumbers() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
