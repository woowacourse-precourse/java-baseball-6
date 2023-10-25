package baseball.model;

import baseball.util.NumberGeneration;
import java.util.List;

public class Computer {

    private List<Integer> numberList;

    public void generateRandomNumber() {
        NumberGeneration numberGeneration = new NumberGeneration();
        numberList = numberGeneration.getComputerNumber();
    }

    public List<Integer> getRandomNumberList() {
        return numberList;
    }

}
