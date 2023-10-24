package baseball.controller;

import baseball.model.EndGame;
import baseball.model.InputNum;
import baseball.model.RandomNum;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private List<Integer> userNum;
    private List<Integer> comNum;
    private int strikeNum;
    private int ballNum;
    private boolean restart;
    private boolean restartCheck = true;
    private final RandomNum randomNum = new RandomNum();
    private final InputNum inputNum = new InputNum();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.startGame();
        comNum = randomNum.generateRandomNum();
        gamePlay();
    }

    public void gamePlay() {
        userNum = inputNum.convertInputToArr(inputView.inputNum());
        Result result = new Result(userNum, comNum);
        strikeNum = result.calculateStrike();
        ballNum = result.calculateBall();
        showResult();
    }

    public void showResult() {
        restart = outputView.showResult(strikeNum, ballNum);
        if (restart){
            EndGame endGame = new EndGame(inputView.gameRestart());
            restartCheck = endGame.isLast();
            if (restartCheck) {
                start();
            }
        }
        while (restartCheck) {
            gamePlay();
        }
    }
}