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
        List<Integer> computerNumbers = RandomNumberCreator.createRandomNumber();
        recursiveGame(computerNumbers);
        OutputView.printInputRestartGame();
        // 게임 재시작 여부 묻기
        if (InputView.inputRestartGame() == 1) {
            run();
        }
    }

    private void recursiveGame(List<Integer> computerNumbers) {
        OutputView.printInputNumber();
        List<Integer> numbers = InputView.inputNumber();
        GameResult gameResult = gameService.checkResult(numbers, computerNumbers);
        OutputView.printGameResult(gameResult);

        if (gameService.isGameOver(gameResult)) {
            return;
        }

        recursiveGame(computerNumbers);
    }

}
