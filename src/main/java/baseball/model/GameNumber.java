package baseball.model;

import java.util.List;

public class GameNumber {
    List<Integer> number;

    public GameNumber(List<Integer> inputNumber) {
        number = inputNumber;
    }

    public List<Integer> getNumber() {
        return number;
    }
}
