package baseball.model;

import java.util.List;

public class GameNumbers {
    public static final int GAME_NUMBERS_SIZE = 3;
    private final List<Integer> numbers;

    public GameNumbers(List<Integer> list) {
        numbers = list;
    }

    public Integer get(int i) {
        return numbers.get(i);
    }

    public boolean contains(Integer num) {
        return numbers.contains(num);
    }

    public boolean isEqualToAt(int index, Integer num) {
        return numbers.get(index).equals(num);
    }
}
