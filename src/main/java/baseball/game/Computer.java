package baseball.game;

import baseball.view.Console;

import java.util.List;

public class Computer {

    private List<Integer> numbers;
    private boolean assigned = false;

    public Computer(){

    }

    public void createRandomNumber() {
        if (assigned) {
            return;
        }

        numbers = Console.input3DigitRandomNumber();
        assigned = true;
    }

    public List<Integer> getNumber() {
        return numbers;
    }
}
