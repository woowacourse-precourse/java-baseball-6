package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class GameNumbers {
    private static final int GAME_NUMBERS_SIZE = 3;
    private final List<Integer> numbers = new ArrayList<>(GAME_NUMBERS_SIZE);

    public GameNumbers(List<Integer> list) {
        for (int i = 0; i < GAME_NUMBERS_SIZE; i++) {
            Integer num = list.get(i);
            numbers.add(num);
        }
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
