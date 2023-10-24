package baseball.config;

import baseball.controller.GameController;
import baseball.domain.ball.AnswerCreator;
import baseball.domain.game.Computer;
import baseball.parser.InputParser;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import number.RandomNumberPicker;

public final class Configuration {

    private static boolean isInitialized = false;

    public static GameController createUniqueGameController() {
        // ensureIsNotInitialized();
        final AnswerCreator answerCreator = new AnswerCreator(new RandomNumberPicker());
        final InputParser inputParser = new InputParser(new InputValidator());

        return new GameController(
                new InputView(inputParser),
                new OutputView(),
                new Computer(answerCreator)
        );
    }

    private static void ensureIsNotInitialized() {
        if (isInitialized) {
            throw new IllegalStateException("이미 Application이 초기화 되었습니다.");
        }
        isInitialized = true;
    }
}
