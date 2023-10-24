package baseball.controller;

import baseball.domain.ball.BallNumber;
import baseball.domain.ball.Guess;
import baseball.domain.game.Computer;
import baseball.domain.game.GameResult;
import baseball.domain.game.GameStatus;
import baseball.view.InputView;
import baseball.view.OutputView;
import collection.Triple;

public final class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public GameController(
            final InputView inputView,
            final OutputView outputView,
            final Computer computer
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
    }

    public void play() {
        computer.createAnswer();
        askUntilCorrectGuess(computer);
        replayOrExit();
    }

    private void askUntilCorrectGuess(final Computer computer) {
        final GameResult result = askGuess(computer);
        outputView.printResult(result);

        if (!result.hasThreeStrike()) {
            askUntilCorrectGuess(computer);
        }
    }

    private GameResult askGuess(final Computer computer) {
        final Triple<BallNumber> ballNumbers = inputView.inputBallNumbers();
        final Guess guess = Guess.of(ballNumbers);
        return computer.check(guess);
    }

    private void replayOrExit() {
        final GameStatus status = inputView.inputNextGameStatus();
        if (status == GameStatus.REPLAY) {
            play();
        }
    }
}
