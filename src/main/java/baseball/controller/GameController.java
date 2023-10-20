package baseball.controller;

import baseball.view.StartView;

public class GameController {
    StartView startView = new StartView();

    public void gameStart() {
        startView.printStartGame();
    }


}
