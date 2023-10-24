package baseball.controller;

import baseball.domain.ball.BallNumber;
import baseball.domain.ball.Guess;
import baseball.domain.game.Computer;
import baseball.domain.game.GameResult;
import baseball.domain.game.GameStatus;
import collection.Triple;

public final class GameController {

    private final Computer computer;
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public GameController(
            final InputManager inputManager,
            final OutputManager outputManager,
            final Computer computer
    ) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.computer = computer;
    }

    public void play() {
        computer.createAnswer();
        askUntilCorrectGuess(computer);
        replayOrExit();
    }

    private void askUntilCorrectGuess(final Computer computer) {
        final GameResult result = askGuess(computer);
        outputManager.printHint(result);

        if (!result.hasThreeStrike()) {
            askUntilCorrectGuess(computer);
        }
    }

    private GameResult askGuess(final Computer computer) {
        final Triple<BallNumber> ballNumbers = inputManager.inputBallNumbers();
        final Guess guess = Guess.of(ballNumbers);
        return computer.check(guess);
    }

    private void replayOrExit() {
        final GameStatus status = inputManager.inputNextGameStatus();
        if (status == GameStatus.REPLAY) {
            play();
        }
    }
}
