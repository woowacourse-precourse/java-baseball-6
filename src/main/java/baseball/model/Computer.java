package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    static final int MAX_NUMBER = 9;
    static final int MIN_NUMBER = 1;
    static final int LENGTH_NUMBER = 3;
    private List<Integer> numbers = new ArrayList<>();

    public void setNumbers() {
        while (numbers.size() < LENGTH_NUMBER) {
            int number = getRamdomNumber();
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private int getRamdomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
