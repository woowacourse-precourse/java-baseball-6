package baseball;

import java.util.List;

public class Computer {

    Numbers numbers = new Numbers();

    public List<Integer> getComputerNumbers() {
        return List.copyOf(numbers.getList());
    }
}
