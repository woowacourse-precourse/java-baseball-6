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
        do {
            playGame();
        }while (checkRetry());
    }

    private void playGame() {
        Answer answer = baseballGame.answerGenerate();
        do {
            int inputNumber = inputView.inputNumber();
            String resultMessage = baseballGame.judgeAnswer(answer, inputNumber);
            outputView.readCountsMessage(resultMessage);
        } while (baseballGame.isContinue());
        outputView.readEndMessage();
    }

    private Boolean checkRetry() {
        outputView.readRetryCheckMessage();
        if (baseballGame.checkRetry(inputView.retryCheckNumber())) {
            return true;
        }
        return false;
    }
}
