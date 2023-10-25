package baseball.domain.player;

import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player() {

    }

    public int getIndexNumbers(int i) {
        return numbers.get(i);
    }

    public void updateNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
