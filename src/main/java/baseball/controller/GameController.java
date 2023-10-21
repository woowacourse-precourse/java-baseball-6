package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.service.GameService;
import baseball.service.HintService;
import baseball.view.GameView;

public class GameController {
    private final GameService gameService;
    private final HintService hintService;
    private final GameView gameView;
    private boolean restart = false;

    public GameController() {
        this.gameService = new GameService();
        this.hintService = new HintService();
        this.gameView = new GameView();
    }

    public void StartBaseballGame() {
        BaseballNumbers computerNumber = gameService.generateComputerNumber();
        gameView.startGame();
        while (!restart) {
            String userInput = gameView.getUserInput();
            BaseballNumbers userInputNumber = new BaseballNumbers(userInput);
            String hintMessage = hintService.createHintMessage(computerNumber, userInputNumber);
            gameView.printHintMessage(hintMessage);
            if (hintService.isCorrect(computerNumber, userInputNumber)) {
                int gameType = gameView.endGame();
                if (gameType == 1) {
                    computerNumber = gameService.generateComputerNumber();
                }
                if (gameType == 2) {
                    restart = true;
                }
            }
        }
    }
}
