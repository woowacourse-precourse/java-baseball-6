package baseball.controller;

import baseball.dto.PlayResult;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.controller.GameStatus.*;

public class GameController {

    private static GameStatus gameStatus = PLAYING;

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        OutputView.printGameStart();

        while (gameStatus == PLAYING) {
            play();
        }
    }

    public void play() {
        List<Integer> guessingNumbers = InputView.inputNumbers();
        PlayResult playResult = gameService.attack(guessingNumbers);
        OutputView.printPlayResult(playResult);

        if (playResult.isThreeStrike()) {
            OutputView.printGameEnd();
            gameStatus = END;
        }
    }
}
