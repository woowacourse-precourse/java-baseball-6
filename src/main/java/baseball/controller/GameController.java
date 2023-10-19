package baseball.controller;

import baseball.domain.ball.Answer;
import baseball.domain.ball.AnswerCreator;
import baseball.domain.ball.Guess;
import baseball.domain.dto.GameResult;
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
    final boolean willReplay = guessRecursive(answer);

    if (willReplay) {
      run();
    }
  }

  private boolean guessRecursive(final Answer answer) {
    final Guess guess = Guess.of(inputView.inputBallNumbers());
    final GameResult result = answer.guess(guess);

    outputView.printResult(result);

    if (!result.isClear()) {
      return guessRecursive(answer);
    }
    return inputView.inputWillReplay();
  }
}
