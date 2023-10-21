package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private final int SIZE = 3;

    private List<Integer> numbers;

    public void createNumbers() {
        numbers = new ArrayList<>();
        while (numbers.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            add(randomNumber);
        }
    }

    private void add(final int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
