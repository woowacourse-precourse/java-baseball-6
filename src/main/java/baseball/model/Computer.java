package baseball.model;

import baseball.model.generator.ComputerGenerator;

import java.util.List;


public class Computer {
    private final ComputerGenerator computerGenerator;
    private List<Integer> randomNumber;

    public Computer(ComputerGenerator computerGenerator) {
        this.computerGenerator = computerGenerator;
    }

    public List<Integer> speakNumbers() {
        chooseNumbers();
        return randomNumber;
    }

    private void chooseNumbers() {
        this.randomNumber = computerGenerator.generateList();
    }
}
