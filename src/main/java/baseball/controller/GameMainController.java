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
        boolean endGame = false;

        while (!endGame) {
            gameService.setGame();
            playGame();
            endGame = stopGame();
        }
    }

    public void playGame() {
        boolean correctAnswer = false;

        while(!correctAnswer) {
            inputView.requestUserInput();
            String result = gameService.playGame();
            outputView.printStrikeOrBall(result);

            if(result.equals(THREESTRIKE)) {
                outputView.printCorrectAnswer();
                inputView.requestGameState();
                correctAnswer = true;
            }
        }
    }

    public boolean stopGame() {
        return gameService.stopGame();
    }
}
