package baseball.controller;

import baseball.common.RandomUtility;
import baseball.model.ComputerNumber;
import baseball.view.StartView;
import java.util.Random;

public class GameController {
    StartView startView = new StartView();
    ComputerNumber computerNumber = new ComputerNumber();
    RandomUtility randomUtility = new RandomUtility();

    public void gameStart() {
        startView.printStartGame();
        computerNumber.setComputerNumber(randomUtility.createComputerNumber());
    }

}
