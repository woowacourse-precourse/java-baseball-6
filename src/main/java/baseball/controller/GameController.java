package baseball.controller;

import baseball.model.Command;
import baseball.service.GameService;
import baseball.view.Input;
import baseball.view.Output;

public class GameController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final GameService gameService = new GameService();

    public void play() {
        output.showStartMessage();
        gameService.init();

        while (!gameService.isGameOver()) {
            output.showInputMessage();
            gameService.makePlayer(input.readNumber());

            gameService.judge();
            output.showGameResult(gameService.getJudgement());
        }

        output.showGameOver();
        output.showGameRestartMessage();

        Command.find(input.readNumber());
    }
}
