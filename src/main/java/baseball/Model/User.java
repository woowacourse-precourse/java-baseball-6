package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final int FIRST_INDEX = 0;
    public static final int LAST_INDEX = 2;
    private Numbers numbers;

    public User(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public int compareAndCount(Computer computer) {
        Numbers computerNumbers = computer.getNumbers();
        return numbers.
    }


    public int countSameIndexAndNumber(Computer computer) {
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
