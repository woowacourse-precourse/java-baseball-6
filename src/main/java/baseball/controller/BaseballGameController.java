package baseball.controller;

import baseball.Answer;
import baseball.BaseballGame;
import baseball.view.OutputView;
public class BaseballGameController {
    OutputView outputView;
    BaseballGame baseballGame;

    public BaseballGameController() {
        this.outputView = new OutputView();
        this.baseballGame = new BaseballGame();
    }

    /*
    * 게임을 최초 시작하는 기능
    * */
    public void startGame() {
        outputView.readStartMessage();
        Answer answer = baseballGame.answerGenerate();
    }
}
