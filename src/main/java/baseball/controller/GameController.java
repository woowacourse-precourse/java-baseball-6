package baseball.controller;

import baseball.domain.GameResult;
import baseball.domain.RandomNumberCreator;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private final GameService gameService = new GameService();

    public void run() {
        OutputView.printStartGame();
        startOneRound();
    }

    private void startOneRound() {
        List<Integer> computerNumbers = RandomNumberCreator.createRandomNumber();
        playGame(computerNumbers);
        askRestartGame();
    }

    private void askRestartGame() {
        OutputView.printInputRestartGame();
        if (InputView.inputRestartGame() == 1) {
            startOneRound();
        }
    }

    private void playGame(List<Integer> computerNumbers) {
        OutputView.printInputNumber();
        List<Integer> numbers = InputView.inputNumber();
        GameResult gameResult = gameService.checkResult(numbers, computerNumbers);
        OutputView.printGameResult(gameResult);

        if (gameService.isGameOver(gameResult)) {
            return;
        }

        playGame(computerNumbers);
    }
}
