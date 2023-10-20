package baseball.controller;

import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallGameResult;
import baseball.domain.BaseBallNumbers;
import baseball.domain.GameRestartStatus;
import baseball.domain.NumberGenerator;
import baseball.dto.request.GameRestartDto;
import baseball.dto.request.PlayerNumberDto;
import baseball.dto.response.GameResultDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final NumberGenerator numberGenerator;

    public GameController(OutputView outputView, InputView inputView, NumberGenerator numberGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        printGameStartMessage();
        playingGame();
    }

    private void printGameStartMessage() {
        outputView.printGameStart();
    }

    private void playingGame() {
        do {
            BaseBallGame game = initBaseBallGame();
            playSingleGameUntilEnd(game);
        } while (isRestartGame());
    }

    private void playSingleGameUntilEnd(BaseBallGame game) {
        while (game.isNotEnd()) {
            BaseBallNumbers playerNumbers = scanPlayerBaseBallNumbers();
            printGameResult(game, playerNumbers);
        }
    }

    private BaseBallNumbers scanPlayerBaseBallNumbers() {
        PlayerNumberDto playerNumberDto = inputView.scanPlayerNumbers();
        return BaseBallNumbers.generateNumbers(playerNumberDto.getPlayerNumbers());
    }

    private void printGameResult(BaseBallGame game, BaseBallNumbers playerNumbers) {
        BaseBallGameResult baseBallGameResult = game.calculateResult(playerNumbers);
        outputView.printGameResult(new GameResultDto(baseBallGameResult));
    }

    private BaseBallGame initBaseBallGame() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.generateRandomNumbers(numberGenerator);
        return BaseBallGame.init(computerNumbers);
    }

    private boolean isRestartGame() {
        GameRestartStatus gameRestartStatus = scanGameReStartStatus();
        return gameRestartStatus.isRestart();
    }

    private GameRestartStatus scanGameReStartStatus() {
        GameRestartDto gameRestartDto = inputView.scanGameRestart();
        return GameRestartStatus.from(gameRestartDto.getGameRestartNumber());
    }

}
