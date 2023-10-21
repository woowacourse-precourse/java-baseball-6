package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.RandomAnswerGenerator;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    public static void run() {
        OutputView.startGame();
        boolean isContinue = true;
        while (isContinue) {
            Computer computer = getComputer();
            play(computer);
            OutputView.endGame();
            isContinue = InputView.continueOrExit();
        }
    }

    private static Computer getComputer() {
        RandomAnswerGenerator answerGenerator = new RandomAnswerGenerator();
        return new Computer(answerGenerator);
    }

    private static void play(Computer computer) {
        boolean isStrikeOut = false;
        while (!isStrikeOut) {
            Score score = computer.getScore(InputView.baseballNumber());
            OutputView.matchResult(score);
            isStrikeOut = score.isStrikeOut();
        }
    }
}
