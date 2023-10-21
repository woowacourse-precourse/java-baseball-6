package baseball.domain;

import baseball.util.ComputerNumberGenerator;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;
    private ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers() {
        computerNumbers = computerNumberGenerator.computerNumberGenerator();
    }
}
