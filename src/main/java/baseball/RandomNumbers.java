package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private static final int NUMBER_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private List<Integer> numbers;

    public RandomNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void setRandomNumbers() {
        while (numbers.size() < NUMBER_LENGTH) {
            int n = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(n)) {
                numbers.add(n);
            }
        }
    }

    public void add(Integer number) {
        numbers.add(number);
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }

    public List<Integer> getAllNumbers() {
        return new ArrayList<>(numbers);
    }

}
