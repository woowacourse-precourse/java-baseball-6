package baseball;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public void clearNumbers() {
        numbers.clear();
    }

    public abstract void setNumbers();
}
