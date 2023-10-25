package baseball.model;

import baseball.model.generator.ComputerNumberGenerator;

import java.util.List;


public class Computer {
    private final ComputerNumberGenerator computerNumberGenerator;
    private List<Integer> randomNumber;

    public Computer(ComputerNumberGenerator computerNumberGenerator) {
        this.computerNumberGenerator = computerNumberGenerator;
    }

    public List<Integer> speakNumbers() {
        chooseNumbers();
        return randomNumber;
    }

    private void chooseNumbers() {
        this.randomNumber = computerNumberGenerator.generateList();
    }
}
