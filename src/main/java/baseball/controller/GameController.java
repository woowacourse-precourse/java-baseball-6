package baseball.controller;

import baseball.domain.GameStatus;
import baseball.response.GameResponse;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private static final GameController instance = new GameController();
    private final GameService gameService = GameService.getInstance();
    private GameStatus currentGameStatus = GameStatus.CONTINUE;

    public static GameController getInstance() {
        return instance;
    }

    public void run() {
        OutputView.printGameStart();
        playGame();
    }

    private void playGame() {
        initializeGame();
        do {
            OutputView.printInputNumber();
            List<Integer> numbers = InputView.inputNumbers();

            currentGameStatus = playGameRound(numbers);
        } while (currentGameStatus != GameStatus.END);
        handleGame();
    }

    private GameStatus playGameRound(List<Integer> numbers) {
        GameResponse response = gameService.playGame(numbers);
        OutputView.printGameResult(response);
        return response.getGameStatus();
    }

    private void handleGame() {
        OutputView.printGameEnd();
        OutputView.printGameRestart();
        GameStatus option = GameStatus.fromInt(InputView.inputRestart());

        if (option == GameStatus.END) {
            return;
        }
        playGame();
    }

    public void initializeGame() {
        gameService.initializeGame();
    }
}
