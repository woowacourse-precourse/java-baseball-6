package baseball.controller;

import baseball.common.RandomUtility;
import java.util.List;

public class ComputerController {
    private List<Integer> computerNumber;

    public void startGame() {
        computerNumber = RandomUtility.createComputerNumber();
    }
}
