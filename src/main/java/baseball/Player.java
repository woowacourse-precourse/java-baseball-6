package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers = new ArrayList<>();

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int get(int index) {
        return numbers.get(index);
    }
}
