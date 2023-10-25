package controller;

import view.PlayGameInformationOutputView;
import view.PlayerNumberInputView;
import model.Computer;
import model.Player;

public class BaseballGameController {
    PlayGameInformationOutputView playGameInformationOutputView = new PlayGameInformationOutputView();
    PlayerNumberInputView playerNumberInputView = new PlayerNumberInputView();
    Computer computer = new Computer();
    Player player = new Player();

    public void gameProgress() {
        playGameInformationOutputView.printGameStart();
        computer.generateBalls();
        playerNumberInputView.guideInformation();
        player.generateBalls(playerNumberInputView.receiveNumber());
    }
}
