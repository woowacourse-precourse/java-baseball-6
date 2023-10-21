package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int COMPUTER_NUMBER_COUNT = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private final List<Integer> numbers = new ArrayList<>();

    public void selectNumbers() {
        while (numbers.size() < COMPUTER_NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public void init() {
        numbers = new ArrayList<>();
    }
}
