package baseball.controller;

import baseball.domain.ball.Guess;
import baseball.domain.ball.GuessResult;
import baseball.domain.game.Computer;
import baseball.domain.game.GameStatus;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

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
        computer.resetAnswer();
        askUntilCorrectGuess(computer);
        replayOrExit();
    }

    private void askUntilCorrectGuess(final Computer computer) {
        final GuessResult result = askGuess(computer);
        outputView.printResult(result);

        if (!result.hasThreeStrike()) {
            askUntilCorrectGuess(computer);
        }
    }

    private GuessResult askGuess(final Computer computer) {
        final List<Integer> numbers = inputView.inputBallNumbers();
        final Guess guess = Guess.of(numbers);
        return computer.check(guess);
    }

    private void replayOrExit() {
        if (GameStatus.REPLAY == inputView.inputNextGameStatus()) {
            play();
        }
    }
}
