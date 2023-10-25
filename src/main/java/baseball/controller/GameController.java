package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.GameResultDTO;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final GameService gameService = new GameService();
    private GameResultDTO gameResultDTO;

    public GameController() {
        gameStartMessage();
    }

    // 게임 진행
    private void playGame() {
        inputNumberMessage();
        GameNumber playerNumbers = inputView.playerNumberInput();
        gameResultDTO = gameService.calculateGameResult(playerNumbers);
        gameResultMessage();
        isGameFinished();
    }

    public void run() {
        generateComputerNumber();
        playGame();
        restartOrExit();
    }

    private void inputNumberMessage() {
        outputView.inputNumber();
    }

    private void gameResultMessage() {
        outputView.displayGameResult(gameResultDTO);
    }

    private void gameStartMessage() {
        outputView.startGame();
    }

    private void generateComputerNumber() {
        gameService.setComputerNumber();
    }

    private void isGameFinished() {
        if (!gameResultDTO.getIsGameFinished()) {
            playGame();
            return;
        }
        outputView.displayEndGameMessage();
    }

    private void restartOrExit() {
        GameNumber inputNum = inputView.restartOrExitInput();
        if (inputNum.getNumber().get(0) == 1) {
            run();
        }
    }
}
