package baseball.domain;

import baseball.utility.RandomNumberGenerator;

import java.util.List;

public class Computer {

    List<Integer> computerNumbers;

    public Computer(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public static Computer generateComputer() {
        return new Computer(RandomNumberGenerator.generateNotDuplicatedRandomNumbers());
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

}
