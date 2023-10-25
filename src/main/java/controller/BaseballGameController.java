package controller;

import view.PlayGameInformationOutputView;

public class BaseballGameController {
    PlayGameInformationOutputView playGameInformationOutputView = new PlayGameInformationOutputView();

    public void gameProgress() {
        playGameInformationOutputView.printGameStart();
    }
}
