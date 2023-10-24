package baseball.controller;

import baseball.domain.GameResult;
import baseball.service.GameService;
import baseball.service.PlayerService;
import baseball.util.GameCommand;
import baseball.util.GameConstants;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final GameService gameService;
    private final PlayerService playerService;
    private final InputView inputView;
    private final OutputView outputView;
    private final GameResult gameResult;

    public GameController(GameService gameService, PlayerService playerService, InputView inputView,
                          OutputView outputView, GameResult gameResult) {
        this.gameService = gameService;
        this.playerService = playerService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameResult = gameResult;
    }

    public void startGame() {
        while (true) {
            init();
            run();

            if (exit()) {
                break;
            }
        }
    }

    public void init() {
        gameService.assignComputerNums();
    }

    public void run() {
        while (true) {
            inputView.printGuessPrompt();
            String guessNumber = playerService.inputGuessNumber();
            List<Integer> playerNums = playerService.assignPlayerNums(guessNumber);

            gameService.checkGuessNumbers(playerNums, gameResult);

            int strikeCount = gameResult.getStrikeCount();
            int ballCount = gameResult.getBallCount();

            outputView.printGameResult(strikeCount, ballCount);
            gameResult.resetGameResult();

            if (strikeCount == GameConstants.DIGIT_SIZE) {
                outputView.printSuccessMessage();
                break;
            }
        }
    }

    public boolean exit() {
        inputView.printGameOverMessage();
        GameCommand gameCommand = playerService.inputCommand();

        if (gameCommand == GameCommand.GAME_RESTART) {
            return false;
        }

        return true;
    }
}
