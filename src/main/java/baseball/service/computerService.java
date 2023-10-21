package baseball.service;

import baseball.domain.Computer;

import java.util.List;

public class computerService {
    private Computer computer = new Computer();

    public void generateRandom() {
        List<Integer> randomNumber = computer.getComputerNumber();
        while (randomNumber.size() < 3) {
            computer.createOne();
        }
    }

    public void resetRandom() {
        computer.reset();
    }
}
