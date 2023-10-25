package controller;

import model.Computer;
import model.Game;
import model.User;
import service.BaseBallGameService;
import view.BaseballGameView;

public class BaseBallGameController {

    BaseBallGameService baseBallGameService = new BaseBallGameService(new BaseballGameView(), new Game(), new User(), new Computer());

    public void playBaseballGame(){
        baseBallGameService.runGame();
    }

}
