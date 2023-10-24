package baseball.controller;

import baseball.service.GameService;
import baseball.view.View;

public class UserController implements Controller {
    private final View inputView;
    private final GameService gameService;

    public UserController(View inputView, GameService gameService) {
        this.inputView = inputView;
        this.gameService = gameService;
    }

    @Override
    public void gameStart() {
        inputView.renderView();
        gameService.playBallGame();
    }
}