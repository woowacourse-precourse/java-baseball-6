package baseball.domain.player;


import baseball.domain.number.Numbers;
import java.util.List;

public class Human implements Player {

    private Numbers numbers;

    private Human() {
    }

    public static Human create() {
        return new Human();
    }

    @Override
    public Numbers getNumbers() {
        return numbers;
    }

    @Override
    public List<Integer> getNumberList() {
        return numbers.getNumberList();
    }

    @Override
    public void changeNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public void reset() {
        this.numbers = null;
    }

}
