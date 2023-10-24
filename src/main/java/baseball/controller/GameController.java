package baseball.controller;

import baseball.domain.GameStatus;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.service.ScoreBoardService;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.domain.GameStatus.*;

public class GameController {

    private final InputController inputController;
    private final OutputView outputView;
    private final InputView inputView;
    private final ComputerService computerService;
    private final PlayerService playerService;
    private final ScoreBoardService scoreBoardService;
    public GameController(InputController inputController,
                          OutputView outputView,
                          InputView inputView,
                          ComputerService computerService,
                          baseball.service.PlayerService playerService,
                          baseball.service.ScoreBoardService scoreBoardService) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.inputView = inputView;
        this.computerService = computerService;
        this.playerService = playerService;
        this.scoreBoardService = scoreBoardService;
    }

    public void intro() {
        outputView.printStartGameMessage();
    }

    public void run() {
        GameStatus gameStatus = RESTART;
        while (gameStatus == RESTART) {
            setGame();
            playGame();
            String restartChoice = requestRestartChoice();
            gameStatus = handleRestartChoice(restartChoice);
        }
    }

    private void setGame() {
        computerService.setup();
    }

    private void playGame() {
        GameStatus roundStatus = CONTINUE;
        while (roundStatus == CONTINUE) {
            String playerGuess = requestPlayerGuess();
            playerService.generatePlayerBaseballs(playerGuess);
            int ballCount = computerService.calculateBallCount();
            int strikeCount = computerService.calculateStrikeCount();
            scoreBoardService.updateScoreBoard(ballCount, strikeCount);
            outputView.printResultMessage(scoreBoardService.generateGameResult());
            roundStatus = updateGameStatus(roundStatus);
        }
        outputView.printEndGameMessage();
    }

    private GameStatus updateGameStatus(GameStatus roundStatus) {
        if (scoreBoardService.isThreeStrike()) {
            roundStatus = BREAK;
        }
        return roundStatus;
    }

    private String requestPlayerGuess() {
        inputView.printPlayerGuessMessage();
        return inputController.requestPlayerGuess();
    }

    private String requestRestartChoice() {
        inputView.printRestartChoiceMessage();
        return inputController.requestRestartChoice();
    }

    private GameStatus handleRestartChoice(String restartChoice) {
        int value = Integer.parseInt(restartChoice);
        if (value == RESTART.getValue()) {
            return RESTART;
        } else if (value == EXIT.getValue()) {
            return EXIT;
        } else {
            throw new IllegalArgumentException("입력 값은 1 또는 2 입니다. (1: 재 시작, 2: 종료)");
        }
    }
}
