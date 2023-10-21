package baseball.model.domain;

import baseball.model.service.ComputerNumber;
import baseball.model.service.ComputerNumberImpl;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;

    public Computer() {
        ComputerNumber computerNumber = new ComputerNumberImpl();
        this.computerNumbers = computerNumber.generate();
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
