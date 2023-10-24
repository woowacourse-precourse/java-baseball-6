package baseball.controller;

import baseball.service.GameService;

public class UserController implements Controller {
    private final GameService gameService;

    public UserController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void gameStart() {
        gameService.solvingProblem();
    }
}