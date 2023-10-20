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
        gameService.init();

        output.showInputMessage();
        gameService.makePlayer(input.readNumber());

        gameService.judge();
        output.showGameResult(gameService.getJudgement());
    }
}
