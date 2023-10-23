package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.service.GameService;
import baseball.service.HintService;
import baseball.view.GameView;

public class GameController {
    private final GameService gameService;
    private final HintService hintService;
    private final GameView gameView;
    private boolean stopGame = false;

    public GameController() {
        this.gameService = new GameService();
        this.hintService = new HintService();
        this.gameView = new GameView();
    }

    public void StartBaseballGame() {
        BaseballNumbers computerNumber = gameService.generateComputerNumber();
        gameView.startGame();
        playBaseballGame(computerNumber);
    }

    private void playBaseballGame(BaseballNumbers computerNumber) {
        while (!stopGame) {
            String userInput = gameView.getUserInput();
            BaseballNumbers userInputNumber = new BaseballNumbers(userInput);
            String hintMessage = hintService.createHintMessage(computerNumber, userInputNumber);
            gameView.printHintMessage(hintMessage);
            computerNumber = manageGameResult(computerNumber, userInputNumber);
        }
    }

    private BaseballNumbers manageGameResult(BaseballNumbers computerNumber, BaseballNumbers userInputNumber) {
        if (hintService.isCorrect(computerNumber, userInputNumber)) {
            int gameType = gameView.endGame();
            validateGameCode(gameType);

            if (gameType == 1) {
                computerNumber = gameService.generateComputerNumber();
            }
            if (gameType == 2) {
                stopGame = true;
            }
        }

        return computerNumber;
    }

    private void validateGameCode(int gameType) {
        if (gameType != 1 && gameType != 2) {
            throw new IllegalArgumentException("올바르지 않은 게임 유형 코드입니다.");
        }
    }
}
