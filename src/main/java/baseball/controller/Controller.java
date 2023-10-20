package baseball.controller;

import baseball.service.Service;
import baseball.view.OutPut;
import baseball.view.UserInPut;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    UserInPut userInPut = new UserInPut();
    Service service = new Service();
    OutPut outPut = new OutPut();

    public void start() {
        gameStart();
        gameOn();
        endGame();
        gameRestart();
    }

    public void gameStart() {
        outPut.gameStartMessageView();
        service.setGame();
    }

    public void gameOn() {
        service.onGame();
    }

    public void endGame() {
        outPut.endGameMessage();
    }

    public void gameRestart() {
        service.setGame();
        service.gameRestart();
    }
}
