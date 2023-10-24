package baseball.users;

import java.util.List;

public class Player {

    List<Integer> numbers;

    public Player(List<Integer> playerNumbers) {
        this.numbers = playerNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
