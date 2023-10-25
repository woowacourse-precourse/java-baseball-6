package baseball.repository;

import java.util.List;

public class Computer {
    private static Computer computer;

    private List<Integer> computerNumbers;

    private Computer() {
    }

    public static Computer getInstance() {
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

}
