package baseball.model.domain;

import baseball.model.service.ComputerNumber;
import baseball.model.service.ComputerNumberImpl;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        ComputerNumber computerNumber = new ComputerNumberImpl();
        this.numbers = computerNumber.generate();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
