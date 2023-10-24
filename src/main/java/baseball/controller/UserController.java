package baseball.controller;

import baseball.service.GameService;
import baseball.view.View;

public class UserController implements Controller {
    private final View computerView;
    private final GameService gameService;

    public UserController(View computerView, GameService gameService) {
        this.computerView = computerView;
        this.gameService = gameService;
    }

    @Override
    public void gameStart() {
        computerView.renderView();
        gameService.solvingProblem();
    }
}