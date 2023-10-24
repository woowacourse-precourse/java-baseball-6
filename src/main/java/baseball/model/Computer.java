package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static List<Integer> computerNumbers = new ArrayList<>();

    public void setComputerNumbers(List<Integer> computerNumbers) {
        Computer.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerNumbers=" + computerNumbers +
                '}';
    }

}
