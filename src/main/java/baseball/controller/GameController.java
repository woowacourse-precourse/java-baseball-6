package baseball.controller;

import baseball.dto.PlayResult;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.controller.GameStatus.*;

public class GameController {

    private static final int GAME_RESTART_OPTION = 1;
    private static final int GAME_EXIT_OPTION = 2;

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
            checkGameRestart();
        }
    }

    private void checkGameRestart() {
        int gameRestart = InputView.inputGameRestart();

        validationGameRestart(gameRestart);

        if (gameRestart == GAME_RESTART_OPTION) {
            gameService.resetGame();
            gameStatus = PLAYING;
        }
    }

    private void validationGameRestart(int gameRestart) {
        if (gameRestart != GAME_RESTART_OPTION && gameRestart != GAME_EXIT_OPTION) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}
