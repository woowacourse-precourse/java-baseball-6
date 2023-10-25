package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Validator;
import baseball.view.UserView;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.Constants.*;

public class GameController {

    private UserView userView;
    private Validator validator;
    private BaseballGame baseballGame;

    public GameController() {
        userView = new UserView();
        validator = new Validator();
        baseballGame = new BaseballGame();
    }

    public void playBaseballGame() {
        userView.displayStartMessage();

        //TODO playGame 코드
    }

}
