package baseball.controller;

import baseball.service.GameService;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final GameService gameService;
    private final OutputView outputView;

    public GameController() {
        gameService = new GameService();
        outputView = new OutputView();
    }

    public void start() {
        outputView.start();
    }

    public void play(String input) {
        gameService.setUserBaseballNumber(input);

        List<Integer> result = gameService.calculateBaseBall();

        outputView.printHint(result.get(0), result.get(1));
    }

    public boolean restart(String input) {
        return gameService.restart(input);
    }

    public boolean isWin() {
        if (gameService.isWin()) {
            outputView.printWin();
            return true;
        }
        return false;
    }
}
