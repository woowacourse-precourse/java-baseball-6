package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private static final String PLAY_GAME_STATUS = "playing";
    private static final String END_GAME_STATUS = "end";

    private static final int RESTART_NUM = 1;
    private static final int END_NUM = 2;

    private static String gameStatus;

    public void run() {
        gameStatus =PLAY_GAME_STATUS;
        gameStart();
        while (gameStatus.equals(PLAY_GAME_STATUS)){
            gamePlay();
            gameEnd();
            restartOrEnd();
        }
    }
    public void gameStart(){
        OutputView.gameStartOutput();
    }
    public void gamePlay(){
        String myNum = InputView.inputNum();

    }
    public void gameEnd(){
        OutputView.gameEndOutput();
    }
    public void restartOrEnd(){
        int restartNum = InputView.restart();
        if(restartNum == END_NUM){
            gameStatus = END_GAME_STATUS;
        }
    }
}
