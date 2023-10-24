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

        while (true) {
            if (gameService.getUserNumbers()) {
                outputMessage.printGameReallyEndMessage();
                break;
            }
            if (gameService.sameNumbers()) {
                outputMessage.printGameEndMessage();
                if (gameService.notRestart()) {
                    outputMessage.printGameReallyEndMessage();
                    break;
                } else {
                    gameService.setComputerNumbers();
                }
            }

        }
    }
}
