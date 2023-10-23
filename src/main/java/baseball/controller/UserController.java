package baseball.controller;

import baseball.domain.GameService;

public class UserController {
    private final GameService gameService;

    public UserController(GameService gameService) {
        this.gameService = gameService;
    }

    public void gameStart() {
        gameService.solvingProblem();
    }
}