package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.RandomAnswerGenerator;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    public static void run() {
        RandomAnswerGenerator answerGenerator = new RandomAnswerGenerator();
        Computer computer = new Computer(answerGenerator);
        OutputView.startGame();
        do {
            play(computer);
            OutputView.endGame();
            computer.initAnswer(answerGenerator);
        } while (InputView.continueOrExit());
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
