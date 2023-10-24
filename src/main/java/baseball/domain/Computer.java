package baseball.domain;

import baseball.util.GenerateComputerGameNumber;
import java.util.List;

public class Computer {
    private List<Integer> computerGameNumbers;
    private GenerateComputerGameNumber generateComputerGameNumber = new GenerateComputerGameNumber();

    public List<Integer> getComputerGameNumbers() {
        return computerGameNumbers;
    }

    public void setupGameNumbers() {
        computerGameNumbers = generateComputerGameNumber.generateComputerGameNumber();
    }
}