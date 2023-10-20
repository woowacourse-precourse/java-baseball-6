package baseball.domain.player;


import baseball.domain.number.Numbers;
import java.util.List;

public class Player {

    private Numbers numbers;

    private Player() {
    }

    public static Player create(Numbers numbers) {
        Player player = new Player();
        player.setNumbers(numbers);

        return player;
    }

    private void setNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return Numbers.create(numbers.getNumberList());
    }

    public List<Integer> getNumberList() {
        return numbers.getNumberList();
    }

}
