package baseball.Domain;

import baseball.Util.ComputerNumberGenerator;
import java.util.List;

public class Computer {
    private final ComputerNumberGenerator computerNumberGenerator;
    private List<Integer> computerNumbers;

    public Computer() { //필드와 생성자 분리
        computerNumberGenerator = new ComputerNumberGenerator();
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers() {
        computerNumbers = computerNumberGenerator.computerNumberGenerator();
    }
}
