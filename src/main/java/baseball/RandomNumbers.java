package baseball;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    private static final int MAX_SIZE = 3;

    private List<Number> randomNumbers = new ArrayList<>();

    public boolean isFull() {
        return randomNumbers.size() == MAX_SIZE;
    }

    public boolean contains(Number newNumber) {
        return randomNumbers.contains(newNumber);
    }

    public void add(Number newNumber) {
        randomNumbers.add(newNumber);
    }
}
