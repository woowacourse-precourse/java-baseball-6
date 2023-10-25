package baseball.controller;


import baseball.service.GameService;
import baseball.view.OutputMessage;

public class GameController {

    OutputMessage outputMessage = new OutputMessage();
    GameService gameService = new GameService();
    public void startGame() {
        outputMessage.printGameStartMessage();
        gameService.setComputerNumbers();

        boolean gameStatus = true;
        while (gameStatus) {
            gameService.getUserNumbers();

            if (gameService.sameNumbers()) {
                outputMessage.printGameEndMessage();
                gameStatus = false;
            }

        }
    }

}
