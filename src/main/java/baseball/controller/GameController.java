package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.GameService;
import baseball.service.UserService;

public class GameController {
    private final ComputerService computerService;
    private final GameService gameService;
    private final UserService userService;

    public GameController(final ComputerService computerService,
                          final GameService gameService,
                          final UserService userService) {
        this.computerService = computerService;
        this.gameService = gameService;
        this.userService = userService;
    }
}
