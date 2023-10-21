package baseball.domain;

public class Player {

    private final Numbers numbers;

    public Player(Numbers numbers) {
        this.numbers = numbers;
    }

    public int getByPosition(int position) {
        return numbers.getByPosition(position);
    }
}