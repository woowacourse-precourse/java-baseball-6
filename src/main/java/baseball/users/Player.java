package baseball.users;

import java.util.List;

public class Player {

    private List<Integer> numbers;

    public Player() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void changeNumbers(List<Integer> playerNumbers) {
        this.numbers = playerNumbers;
    }

}
