package controller;

import view.PlayGameInformationOutputView;
import view.PlayerNumberInputView;

public class BaseballGameController {
    PlayGameInformationOutputView playGameInformationOutputView = new PlayGameInformationOutputView();
    PlayerNumberInputView playerNumberInputView = new PlayerNumberInputView();

    public void gameProgress() {
        playGameInformationOutputView.printGameStart();
        playerNumberInputView.receiveNumber();
    }
}
