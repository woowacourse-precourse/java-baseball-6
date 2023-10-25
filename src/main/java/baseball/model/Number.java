package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Number {
    int NUMBER_SIZE = 3;
    List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContained(int number) {
        return numbers.contains(number);
    }

    public boolean isCompleted() {
        return numbers.size() == NUMBER_SIZE;
    }
}
