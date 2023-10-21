package baseball.controller;

import baseball.config.GameCommand;
import baseball.domain.GameResult;
import baseball.service.GameService;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private final GameService service;

    public GameController() {
        this.service = new GameService(new RandomNumberGenerator());
    }

    public void run() {
        OutputView.printGameStartMessage();
        service.startGame();
        playGame();
    }

    private void playGame() {
        while (true) {
            playAndPrintGameResult();

            if (service.isGameWon()) {
                OutputView.printGameEndMessage();
                restartOrQuit();
                break;
            }
        }
    }

    private void playAndPrintGameResult() {
        List<Integer> playerBaseBall = InputView.readBaseBallNumbers();
        service.setPlayerBaseball(playerBaseBall);

        GameResult gameResult = service.getGameResult();
        OutputView.printGameResult(gameResult);
    }

    private void restartOrQuit() {
        GameCommand gameCommand = readGameCommand();
        if (gameCommand.equals(GameCommand.QUIT)) {
            return;
        }
        restart(gameCommand);
    }

    private GameCommand readGameCommand() {
        int gameCommand = InputView.readGameCommand();
        return GameCommand.from(gameCommand);
    }

    private void restart(GameCommand gameCommand) {
        if (gameCommand.equals(GameCommand.RETRY)) {
            service.startGame();
            playGame();
        }
    }
}
