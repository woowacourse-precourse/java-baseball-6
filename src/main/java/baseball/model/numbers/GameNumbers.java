package baseball.model.numbers;

import java.util.List;

public class GameNumbers {
    public static final int GAME_NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public GameNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer get(int i) {
        return numbers.get(i);
    }

    public boolean contains(Integer num) {
        return numbers.contains(num);
    }

    public boolean isEqualToAt(int index, GameNumbers other) {
        Integer integer = numbers.get(index);
        return integer.equals(other.get(index));
    }
}
