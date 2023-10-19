package baseball.domain;


import baseball.io.Input;
import java.util.List;

public class Player {

    private Numbers numbers;

    private Player() {
    }

    public static Player create() {

        return new Player();
    }

    public void inputNumber() {
        this.numbers = Numbers.create(Input.inputNumberList());
    }

    public List<Integer> getNumberList() {
        return numbers.getNumberList();
    }
}
