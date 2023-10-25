package baseball.controller;

import baseball.domain.GameStatus;
import baseball.response.GameResponse;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private final GameService gameService = GameService.getInstance();
    private GameStatus currentGameStatus = GameStatus.CONTINUE;


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
    }

    private GameStatus playGameRound(List<Integer> numbers) {
        GameResponse response = gameService.playGame(numbers);
        OutputView.printGameResult(response);
        return response.getGameStatus();
    }

    public void initializeGame() {
        gameService.initializeGame();
    }
}
