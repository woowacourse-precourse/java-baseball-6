package baseball.controller;

import baseball.domain.AnswerGenerator;
import baseball.domain.Computer;
import baseball.domain.Score;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

public class BaseballController {
    private final AnswerGenerator answerGenerator;

    public BaseballController(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    public void run() {
        BaseballOutputView.startGame();
        boolean isContinue = true;
        while (isContinue) {
            Computer computer = new Computer(answerGenerator);
            play(computer);
            BaseballOutputView.endGame();
            isContinue = BaseballInputView.continueOrExit();
        }
    }

    private void play(Computer computer) {
        boolean isStrikeOut = false;
        while (!isStrikeOut) {
            Score score = computer.getScore(BaseballInputView.inputBaseballNumber());
            BaseballOutputView.matchResult(score);
            isStrikeOut = score.isStrikeOut();
        }
    }
}
