package baseball.model;

public class Computer {

    private GameNumbers gameNumbersOfComputer;

    private static final int INITIAL_COUNT_VALUE = 0;

    public Computer() {
    }

    public void pickRandomNumbers() {
        this.gameNumbersOfComputer = GameNumbers.create();
    }

}
