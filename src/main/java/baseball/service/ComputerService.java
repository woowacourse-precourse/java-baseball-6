package baseball.service;

import baseball.domain.Computer;

import java.util.List;

public class ComputerService {
    private Computer computer;

    public ComputerService() {
        computer = new Computer();
    }

    public List<Integer> generateRandom() {
        List<Integer> randomNumber = computer.getComputerNumber();
        while (randomNumber.size() < 3) {
            computer.createOne();
        }
        return randomNumber;
    }

    public void resetRandom() {
        computer.reset();
    }
}
