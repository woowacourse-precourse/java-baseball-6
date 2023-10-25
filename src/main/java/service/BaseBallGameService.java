package service;

import model.Computer;
import model.Game;
import model.User;
import view.BaseballGameView;

public class BaseBallGameService {

    private BaseballGameView baseballGameView;
    private Game game;
    private User user;
    private Computer computer;
    public BaseBallGameService(BaseballGameView baseballGameView, Game game, User user, Computer computer){
        this.baseballGameView = baseballGameView;
        this.game = game;
        this.user = user;
        this.computer = computer;

    }

    public BaseBallGameService(){}

    public void runGame(){

    }

}
