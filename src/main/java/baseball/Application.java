package baseball;

import baseball.controller.GameController;
import baseball.domain.AnswerCreator;
import baseball.view.InputView;
import baseball.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final AnswerCreator answerCreator = new AnswerCreator();
    final GameController gameController = new GameController(inputView, outputView, answerCreator);

    gameController.run();
  }
}
