package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameMainController {

    private static final String THREESTRIKE = "3스트라이크";

    public GameMainController() {
        InputView.startBaseballGame();
    }

    public static void startGame() {
        boolean gameEnd = false;
        while (!gameEnd) {
            GameService.setGame();
            playGame();
            gameEnd = endGame();
        }
    }

    public static void playGame() {
        while (!GameService.playGame().equals(THREESTRIKE)) {
            String result = GameService.playGame();
            OutputView.printStrikeOrBall(result);
        }

        OutputView.printStrikeOrBall(THREESTRIKE);
        OutputView.printCorrectAnswer();
    }

    public static boolean endGame() {
        InputView.requestGameState();
        return GameService.endGame();
    }
}
