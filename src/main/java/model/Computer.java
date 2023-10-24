package model;

import java.util.List;
import util.ComputerNumberGenerator;

public class Computer {
    private List<Integer> computerNumbers;
    private ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers() {
        computerNumbers = computerNumberGenerator.computerNumberGenerator();
    }

}
