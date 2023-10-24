package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.HashMap;

public class BaseballGameController {
    private static final String PLAY_GAME_STATUS = "PLAYING";
    private static final String END_GAME_STATUS = "END";
    private static final String STRIKE_KEY = "STRIKE";
    private static final String BALL_KEY = "BALL";
    private static final int THREE_STRIKE_COUNT = 3;
    private static final String RESTART_NUM = "1";
    private static final String END_NUM = "2";


    private static String gameStatus;

    BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
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
        gameStatus = PLAY_GAME_STATUS;
        OutputView.gameStartOutput();
    }

    public void gameInit() {
        baseballGameService.initUserResult();
    }

    public void gamePlay() {
        while (baseballGameService.StrikeCount() != THREE_STRIKE_COUNT) {
            gameInit();
            String playerNum = InputView.inputNum();
            baseballGameService.judgeCorrectNum(playerNum);
            HashMap<String, Integer> result = baseballGameService
                    .judgeResult(playerNum, baseballGameService.getComputer().getComputerNum());
            OutputView.gameResultOutput(result.get(STRIKE_KEY), result.get(BALL_KEY));
        }
    }

    public void gameEnd() {
        OutputView.gameEndOutput();
    }

    public void restartOrEnd() {
        String restartNum = InputView.restart();
        baseballGameService.judgeCorrectRestartNum(restartNum);
        if (restartNum.equals(RESTART_NUM)) {
            gameStatus = PLAY_GAME_STATUS;
        }
        if (restartNum.equals(END_NUM)) {
            gameStatus = END_GAME_STATUS;
        }
    }

    public String getGameStatus() {
        return gameStatus;
    }
}
