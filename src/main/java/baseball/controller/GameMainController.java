package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameMainController {

    private static final String THREESTRIKE = "3스트라이크";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameService gameService = new GameService();

    public GameMainController() {
        inputView.startBaseballGame();
    }

    public void startGame() {
        boolean gameEnd = false;
        while (!gameEnd) {
            gameService.setGame();
            playGame();
            gameEnd = endGame();
        }
    }

    public void playGame() {
        while (!gameService.playGame().equals(THREESTRIKE)) {
            String result = gameService.playGame();
            outputView.printStrikeOrBall(result);
        }

        outputView.printStrikeOrBall(THREESTRIKE);
        OutputView.printCorrectAnswer();
    }

    public boolean endGame() {
        inputView.requestGameState();
        return gameService.endGame();
    }
}
