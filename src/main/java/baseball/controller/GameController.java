package baseball.controller;

import baseball.domain.ball.AnswerCreator;
import baseball.domain.ball.BallNumbers;
import baseball.domain.dto.GameResult;
import baseball.domain.game.BaseballGame;
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
    final BaseballGame game = createGame();
    playRecursive(game);

    final boolean willReplay = inputView.inputWillReplay();

    if (willReplay) {
      run();
    }
  }

  private BaseballGame createGame() {
    final BallNumbers answer = answerCreator.create();
    return new BaseballGame(answer);
  }

  private void playRecursive(final BaseballGame game) {
    final BallNumbers ballNumbers = BallNumbers.of(inputView.inputBallNumbers());
    final GameResult result = game.play(ballNumbers);

    outputView.printResult(result);

    if (!result.isClear()) {
      playRecursive(game);
    }
  }
}
