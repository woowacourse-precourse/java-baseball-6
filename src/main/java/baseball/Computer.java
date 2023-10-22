package baseball;

import java.util.List;

public class Computer {

    private final List<Integer> computerNumber = BaseballNumber.generateComputerNumber();

    public void printResult(List<Integer> playerNumber) {
        System.out.println(BaseballNumber.getResult(computerNumber, playerNumber));
    }
}
