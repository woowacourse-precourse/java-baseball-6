package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameMainController {

    private static final String THREESTRIKE = "3스트라이크";
    private final GameService gameService = new GameService();

    public GameMainController() {
        InputView.startBaseballGame();
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

        while (!correctAnswer) {
            InputView.requestUserInput();
            String resultMessage = gameService.playGame();
            OutputView.printResultMessage(resultMessage);

            if (resultMessage.equals(THREESTRIKE)) {
                OutputView.printCorrectAnswer();
                InputView.requestGameState();
                correctAnswer = true;
            }
        }
    }

    public boolean stopGame() {
        return gameService.stopGame();
    }
}
