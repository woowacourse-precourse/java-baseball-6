package baseball.slot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseballNumbersSlot {
    protected List<Integer> numbers = new ArrayList<>();
    public abstract void updateNumbers();

    public int get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }
}
