package baseball.application;

import baseball.entity.Baseball;
import baseball.view.OutputView;

import static baseball.utils.InputUtil.*;

public class BaseballGameService {

    private Baseball baseball;

    public void startGame() {
        baseball = new Baseball();
        guessNumber();
        OutputView.printPerfect();

        if (isRestartGame()) {
            reStartGame();
        }
    }

    private void reStartGame() {
        startGame();
    }

    private boolean isRestartGame() {
        OutputView.printEndGame();
        OutputView.printRestartGame();
        String number = requireRestartNumber();
        return number.equals(RESTART_NUMBER);
    }

    private void guessNumber() {
        String guessNumber = requireGuessNumber();

        if (!isGuessNumberPerfect(guessNumber)) {
            getBaseballResult(guessNumber);
            guessNumber();
        }
    }

    private boolean isGuessNumberPerfect(String guessNumber) {
        return baseball.isPerfect(guessNumber);
    }

    private void getBaseballResult(String guessNumber) {
        if (baseball.isNothing(guessNumber)) {
            OutputView.printNothing();
            return;
        }

        int ballCount = baseball.countBall(guessNumber);
        int strikeCount = baseball.countStrike(guessNumber);

        OutputView.printBallCount(ballCount);
        OutputView.printStrikeCount(strikeCount);
    }
}
