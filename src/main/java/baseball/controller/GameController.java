package baseball.controller;

import baseball.dto.request.GameRestartOptionDto;
import baseball.dto.request.PlayerBaseballNumbersDto;
import baseball.dto.response.GameResultDto;
import baseball.model.BaseBallGame;
import baseball.model.BaseBallGameResult;
import baseball.model.BaseBallNumbers;
import baseball.model.GameRestartOption;
import baseball.model.NumberGenerator;
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
        playGame();
    }

    private void printGameStartMessage() {
        outputView.printGameStartMessage();
    }

    private void playGame() {
        do {
            BaseBallGame game = initializeBaseBallGame();
            playUntilGameOver(game);
        } while (isGameRestartRequested());
    }

    private BaseBallGame initializeBaseBallGame() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.createRandomNumbers(numberGenerator);
        return BaseBallGame.create(computerNumbers);
    }

    private void playUntilGameOver(BaseBallGame game) {
        while (game.isInProgress()) {
            BaseBallNumbers playerNumbers = readPlayerBaseBallNumbers();
            BaseBallGameResult baseBallGameResult = game.determineGameResult(playerNumbers);
            printGameResult(baseBallGameResult);
        }
    }

    private BaseBallNumbers readPlayerBaseBallNumbers() {
        PlayerBaseballNumbersDto playerBaseballNumbersDto = inputView.readPlayerBaseBallNumbers();
        return BaseBallNumbers.from(playerBaseballNumbersDto.getPlayerNumbers());
    }

    private void printGameResult(BaseBallGameResult baseBallGameResult) {
        outputView.printGameResult(new GameResultDto(baseBallGameResult));
    }

    private boolean isGameRestartRequested() {
        GameRestartOption gameRestartOption = readGameReStartStatus();
        return gameRestartOption.isRestart();
    }

    private GameRestartOption readGameReStartStatus() {
        GameRestartOptionDto gameRestartOptionDto = inputView.readGameRestartOption();
        return GameRestartOption.from(gameRestartOptionDto.getRestartOptionNumber());
    }

}
