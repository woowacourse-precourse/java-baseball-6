package baseball.model;

import java.util.List;

public class GameNumbers {
    private static final int GAME_NUMBERS_SIZE = 3;
    private final List<Integer> numbers;

    public GameNumbers(List<Integer> list) {
        numbers = list;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GameNumbers gameNumbers = (GameNumbers) obj;
        return numbers.equals(gameNumbers.numbers);
    }

}
