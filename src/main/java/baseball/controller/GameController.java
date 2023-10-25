package baseball.controller;

import baseball.service.GameService;
import baseball.view.OutputMessage;

public class GameController {

    GameService gameService = new GameService();

    OutputMessage outputMessage = new OutputMessage();

    public void startGame() {
        outputMessage.printGameStartMessage();
        gameService.setComputerNumbers();

        boolean gameStatus = true;
        while (gameStatus) {
            gameService.getUserNumbers();

            if (gameService.sameNumbers()) {
                outputMessage.printGameEndMessage();
                gameStatus = gameService.restart();

                if (gameStatus) {
                    gameService.setComputerNumbers();
                }
            }
        }

        outputMessage.printGameReallyEndMessage();
    }


}
