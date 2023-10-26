package baseball.controller;

import baseball.service.GameService;
import baseball.view.Input;
import baseball.view.Output;

public class GameController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final GameService gameService = new GameService();

    public void play() {
        output.showStartMessage();

        do {
            gameService.init();

            while (!gameService.isGameOver()) {
                output.showInputMessage();
                gameService.playGame(input.readNumber());
                output.showGameResult(gameService.getJudgement());
            }

            output.showGameOver();
            output.showGameRestartMessage();
        } while (gameService.restartsGame(input.readNumber()));
    }
}
