package baseball.controller;

import baseball.constant.GameCommand;
import baseball.constant.GameConstants;
import baseball.domain.GameResult;
import baseball.service.GameService;
import baseball.service.PlayerService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final GameService gameService;
    private final PlayerService playerService;
    private InputView inputView;
    private OutputView outputView;
    private GameResult gameResult;

    public GameController(GameService gameService, PlayerService playerService) {
        this.gameService = gameService;
        this.playerService = playerService;
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
        inputView = new InputView();
        outputView = new OutputView();
        gameResult = new GameResult();
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

            if (strikeCount == GameConstants.FIXED_DIGIT_NUMBER) {
                outputView.printSuccessMessage();
                break;
            }

            gameResult.resetGameResult();
        }
    }

    public boolean exit() {
        inputView.printGameOverMessage();
        String command = playerService.inputGameCommand();

        if (command.equals(GameCommand.GAME_RESTART_COMMAND)) {
            return false;
        }

        return true;
    }
}
