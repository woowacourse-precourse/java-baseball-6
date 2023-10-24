package baseball.service;

import baseball.domain.Computer;
import java.util.List;

public class ComputerService {
    public static final int MAX_SIZE = 3;
    private Computer computer;

    public ComputerService() {
        computer = new Computer();
    }

    public List<Integer> generateRandom() {
        List<Integer> randomNumber = computer.getComputerNumber();
        while (randomNumber.size() < MAX_SIZE) {
            computer.createOne();
        }
        return randomNumber;
    }

    public void resetRandom() {
        computer.reset();
    }
}
