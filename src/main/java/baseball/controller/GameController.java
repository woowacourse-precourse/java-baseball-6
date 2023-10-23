package baseball.controller;

import baseball.model.InputNum;
import baseball.model.RandomNum;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private List UserNum;
    private List ComNum;
    private int StrikeNum;
    private int BallNum;
    private boolean Restart;
    private String RestartNum;
    private final RandomNum randomNum = new RandomNum();
    private final InputNum inputNum = new InputNum();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.StartGame();
        ComNum = randomNum.GenerateRandomNum();
        GamePlay();
    }
    public void GamePlay() {
        UserNum = inputNum.convertInputToArr(inputView.InputNum());
        Result result = new Result(UserNum, ComNum);
        StrikeNum = result.calculateStrike();
        BallNum = result.calculateBall();
        ShowResult();
    }

    public void ShowResult(){
        Restart = outputView.showResult(StrikeNum, BallNum);
        while (!Restart){
            GamePlay();
            if(Restart){
                RestartNum = inputView.GameRestart();
                if (RestartNum.equals("1")){
                    start();
                }
            }
        }
    }
}
