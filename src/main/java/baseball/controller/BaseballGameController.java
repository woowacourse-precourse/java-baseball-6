package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.HashMap;

public class BaseballGameController {
    private static final String PLAY_GAME_STATUS = "playing";
    private static final String END_GAME_STATUS = "end";

    private static final int RESTART_NUM = 1;
    private static final int END_NUM = 2;

    private static String gameStatus;

    BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
        gameStatus = PLAY_GAME_STATUS;
        gameStart();
        while (gameStatus.equals(PLAY_GAME_STATUS)) {
            baseballGameService.createComputer();
            gameInit();
            gamePlay();
            gameEnd();
            restartOrEnd();
        }
    }

    public void gameStart() {
        OutputView.gameStartOutput();
    }

    public void gameInit() {
        baseballGameService.initUserResult();
    }

    public void gamePlay() {
        while (baseballGameService.StrikeCount() != 3) {
            String playerNum = InputView.inputNum();
            gameInit();
            HashMap<String, Integer> result = baseballGameService.judgeResult(playerNum);
            OutputView.gameResult(result.get("STRIKE"), result.get("BALL"));
        }
    }

    public void gameEnd() {
        OutputView.gameEndOutput();
    }

    public void restartOrEnd() {
        int restartNum = InputView.restart();
        if (restartNum == END_NUM) {
            gameStatus = END_GAME_STATUS;
        }
    }
}
