package baseball.controller;

import baseball.domain.AnswerGenerator;
import baseball.domain.Computer;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final AnswerGenerator answerGenerator;

    public BaseballController(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    public void run() {
        OutputView.startGame();
        boolean isContinue = true;
        while (isContinue) {
            Computer computer = new Computer(answerGenerator);
            play(computer);
            OutputView.endGame();
            isContinue = InputView.continueOrExit();
        }
    }

    private void play(Computer computer) {
        boolean isStrikeOut = false;
        while (!isStrikeOut) {
            Score score = computer.getScore(InputView.baseballNumber());
            OutputView.matchResult(score);
            isStrikeOut = score.isStrikeOut();
        }
    }
}
