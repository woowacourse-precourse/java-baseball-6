package baseball.controller;

import baseball.model.GameNumber;
import baseball.service.CompareService;
import baseball.service.GameService;
import baseball.view.OutputMessage;

public class GameController {
    GameNumber gameNumber = new GameNumber();

    GameService gameService = new GameService();

    OutputMessage outputMessage = new OutputMessage();

    public void startGame() {
        outputMessage.printGameStartMessage();
        gameService.setComputerNumbers();

        boolean gameStatus = true;
        while (gameStatus) {
            try {
                gameService.getUserNumbers();

                if (gameService.sameNumbers()) {
                    outputMessage.printGameEndMessage();
                    gameStatus = gameService.restart();

                    if (gameStatus) {
                        gameService.setComputerNumbers();
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        outputMessage.printGameReallyEndMessage();
    }


}
