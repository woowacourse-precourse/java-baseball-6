package baseball.model;

import baseball.controller.RandomListMaker;
import java.util.List;

public class ComputerNumber {
    private final List<Integer> number;

    public ComputerNumber() {
        this.number = RandomListMaker.generateRandomNumbers();
    }

    public List<Integer> getNumber(){
        return number;
    }
}
