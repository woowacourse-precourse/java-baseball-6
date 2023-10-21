package baseball.controller;

import baseball.Answer;
import baseball.BaseballGame;
import baseball.JudgedCounts;
import baseball.view.InputView;
import baseball.view.OutputView;
public class BaseballGameController {
    OutputView outputView;
    InputView inputView;
    BaseballGame baseballGame;

    public BaseballGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.baseballGame = new BaseballGame();
    }

    /*
    * 게임을 최초 시작하는 기능
    * */
    public void startGame() {
        outputView.readStartMessage();
        Answer answer = baseballGame.answerGenerate();
        int inputNumber = inputView.inputNumber();
        JudgedCounts judgedCounts = baseballGame.judgeAnswer(answer, inputNumber);
    }

}
