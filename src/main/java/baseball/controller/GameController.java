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
        playGame();
    }

    private void playGame() {
        service.startGame();
        GameCommand gameCommand = GameCommand.RETRY;

        while (gameCommand.equals(GameCommand.RETRY)) {
            List<Integer> playerBaseBall = InputView.readBaseBallNumbers();
            service.setPlayerBaseball(playerBaseBall);
            GameResult gameResult = service.getGameResult();
            OutputView.printGameResult(gameResult);

            if (service.isGameWon()) {
                OutputView.printGameEndMessage();
                int input = InputView.readGameCommand();
                gameCommand = GameCommand.from(input);

                if (gameCommand.equals(GameCommand.QUIT)) {
                    break;
                }

                if (gameCommand.equals(GameCommand.RETRY)) {
                    service.startGame();
                }

            }
        }
    }
}
