package baseball.model;

import baseball.utils.RandomGameNumberGenerator;
import java.util.List;

public class Computer {

    private List<Integer> computerGameNumber;
    private final RandomGameNumberGenerator randomGameNumberGenerator = new RandomGameNumberGenerator();

    public List<Integer> getComputerGameNumber() {
        return computerGameNumber;
    }

    public void setComputerGameNumber() {
        computerGameNumber = randomGameNumberGenerator.generate();
    }
}