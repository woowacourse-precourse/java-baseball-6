package baseball.controller;

import baseball.domain.ball.Answer;
import baseball.domain.ball.AnswerCreator;
import baseball.domain.ball.GameStatus;
import baseball.domain.ball.Guess;
import baseball.domain.dto.GuessResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public final class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final AnswerCreator answerCreator;

    public GameController(
            final InputView inputView,
            final OutputView outputView,
            final AnswerCreator answerCreator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.answerCreator = answerCreator;
    }

    public void run() {
        final Answer answer = answerCreator.create();
        guessRecursive(answer);

        if (GameStatus.REPLAY == inputView.inputNextGameStatus()) {
            run();
        }
    }

    private void guessRecursive(final Answer answer) {
        final GuessResult result = answer.guess(
                Guess.of(inputView.inputBallNumbers())
        );

        outputView.printResult(result);

        if (!result.isThreeStrike()) {
            guessRecursive(answer);
        }
    }
}
