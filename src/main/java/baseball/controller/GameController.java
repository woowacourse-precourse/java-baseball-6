package baseball.controller;

import baseball.domain.Game;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        outputView.outputStartProgram();
        Game game = initGame();
    }

    private Game initGame() {
        GameService gameService = new GameService();
        return Game.numberOf(gameService.getRandomNumbers());
    }
}
