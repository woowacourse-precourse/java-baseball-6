package baseball.controller;

import baseball.domain.GameResult;
import baseball.domain.RandomNumberCreator;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    public static final int RESTART_GAME_FLAG = 1;
    public static final int GAME_END_FLAG = 2;

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

    private void askRestartGame() {
        OutputView.printInputRestartGame();
        int restart = InputView.inputRestartGame();
        validRestartInput(restart);

        if (isGameRestart(restart)) {
            startOneRound();
        }
    }

    private static void validRestartInput(int restart) {
        if (restart != RESTART_GAME_FLAG && restart != GAME_END_FLAG) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private static boolean isGameRestart(int restart) {
        return restart == RESTART_GAME_FLAG;
    }
}
