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
            setupGame();
            playGame();
            endGame();
            gameStatus = requestRestartChoice();
        }
    }

    private void setupGame() {
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
            roundStatus = updateRoundStatus(roundStatus);
        }
    }

    private void endGame() {
        outputView.printEndGameMessage();
    }

    private GameStatus updateRoundStatus(GameStatus roundStatus) {
        if (scoreBoardService.isThreeStrike()) {
            roundStatus = BREAK;
        }
        return roundStatus;
    }

    private String requestPlayerGuess() {
        inputView.printPlayerGuessMessage();
        return inputController.requestPlayerGuess();
    }

    private GameStatus requestRestartChoice() {
        String choice = inputController.requestRestartChoice();
        return GameStatus.fromValue(Integer.parseInt(choice));
    }
}
