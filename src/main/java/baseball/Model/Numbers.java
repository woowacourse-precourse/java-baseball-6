package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static final int FIRST_INDEX = 0;
    public static final int LAST_INDEX = 2;
    List<Integer> numbers;

    public Numbers() {}
    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<Integer>(numbers);
    }

    public int compareAndCount(Numbers computer) {
        int count = 0;
        List<Integer> computerNumbers = computer.getNumbers();
        for (int number : numbers) {
            if (computerNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }


    public int countSameIndexAndNumber(Numbers computer) {
        int strike = 0;
        List<Integer> computerNumbers = computer.getNumbers();
        for (int index = FIRST_INDEX; index <= LAST_INDEX; index++) {
            if (numbers.get(index) == computerNumbers.get(index)) {
                strike++;
            }
        }
        return strike;
    }
}
