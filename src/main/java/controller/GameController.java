package controller;

import camp.nextstep.edu.missionutils.Console;

import service.GameService;
import service.GameServiceImpl;

import view.GameView;

public class GameController {

    private final GameView gameView;
    private final GameService gameService;

    public GameController() {
        gameView = new GameView();
        gameService = new GameServiceImpl();
    }

    public void run() {
        gameView.printStartMessage();
        while(!gameService.getQuit()) {
            gameService.gameStart();
            playGame();
            endProcess();
        }
    }

    private void playGame() {
        while(!gameService.isGameSet()) {
            gameView.printInputNumbersMessage();
            String input = Console.readLine();
            int[] ballStrike = gameService.checkCount(input);
            gameView.printCountMessage(ballStrike);
        }
    }

    private void endProcess() {
        gameView.printEndMessage();
        String input = Console.readLine();
        gameService.restartOrQuit(input);
    }
}
