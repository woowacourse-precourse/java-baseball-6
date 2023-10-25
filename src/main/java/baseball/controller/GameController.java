package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.BaseBallManager;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

public class GameController {
    BaseBallGame baseBallGame = new BaseBallGame();

    public void startGame() {
        OutputView.printStartGameMessage();
        do {
            startOneGame();
            OutputView.printStartNewGameMessage();
            baseBallGame.setRunning(InputView.inputGamePlayNumber());
        } while (baseBallGame.isRunning());
    }

    public void startOneGame() {
        BaseBallManager baseBallManager = new BaseBallManager();
        do {
            String playerBaseBall = InputView.inputPlayerBaseBallNumbers();
            Map<String, Integer> gameResult = baseBallManager.judgeBaseBallGame(playerBaseBall);
            baseBallGame.setRunning(gameResult);
            OutputView.printGameResultMessage(gameResult);
        } while (baseBallGame.isRunning());
        OutputView.printThreeStrikeMessage();
    }
}