package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;

public class UserController implements Controller {
    private final InputView inputView;
    private final GameService gameService;

    public UserController(InputView inputView, GameService gameService) {
        this.inputView = inputView;
        this.gameService = gameService;
    }

    @Override
    public void gameStart() {
        inputView.printGameStartMessage();
        gameService.playBallGame();
    }
}