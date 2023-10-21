package baseball.controller;

import baseball.domain.Game;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        try {
            outputView.outputStartProgram();
            Game game = initGame();
            compareNumber(game);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Game initGame() {
        GameService gameService = new GameService();
        return Game.numberOf(gameService.getRandomNumbers());
    }

    private void compareNumber(Game game) {
        game.compareNumber(inputView.inputNumber());
    }
}
