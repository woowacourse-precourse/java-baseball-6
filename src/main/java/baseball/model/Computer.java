package baseball.model;

import java.util.List;

public class Computer {

    private final List<Integer> computerNumber;

    private Computer(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static Computer createComputerByNumber(List<Integer> computerNumber) {
        return new Computer(computerNumber);
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
