package controller;

import view.PlayGameInformationOutputView;
import view.PlayerNumberInputView;
import model.Computer;

public class BaseballGameController {
    PlayGameInformationOutputView playGameInformationOutputView = new PlayGameInformationOutputView();
    PlayerNumberInputView playerNumberInputView = new PlayerNumberInputView();
    Computer computer = new Computer();

    public void gameProgress() {
        playGameInformationOutputView.printGameStart();
        playerNumberInputView.receiveNumber();
        System.out.println(computer.generateBalls());
    }
}
