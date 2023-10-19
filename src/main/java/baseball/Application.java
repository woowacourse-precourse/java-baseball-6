package baseball;

import baseball.controller.GameController;
import baseball.domain.ball.AnswerCreator;
import baseball.util.NumberPicker;
import baseball.util.RandomNumberPicker;
import baseball.view.InputView;
import baseball.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final NumberPicker numberPicker = new RandomNumberPicker(1, 9);
    final AnswerCreator answerCreator = new AnswerCreator(numberPicker);
    final GameController gameController = new GameController(inputView, outputView, answerCreator);

    gameController.run();
  }
}
