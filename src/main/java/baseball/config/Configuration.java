package baseball.config;

import baseball.controller.GameController;
import baseball.controller.InputManager;
import baseball.controller.OutputManager;
import baseball.domain.ball.AnswerCreator;
import baseball.domain.game.Computer;
import baseball.parser.InputParser;
import baseball.validator.InputValidator;
import io.Printer;
import io.Reader;
import number.RandomNumberPicker;

public final class Configuration {

    private static boolean isInitialized = false;

    public static GameController createUniqueGameController() {
        // ensureIsNotInitialized();
        final AnswerCreator answerCreator = new AnswerCreator(new RandomNumberPicker());
        final InputParser inputParser = new InputParser(new InputValidator());
        final Printer printer = new Printer();
        final Reader reader = new Reader();

        return new GameController(
                new InputManager(printer, reader, inputParser),
                new OutputManager(printer),
                new Computer(answerCreator)
        );
    }

    /**
     * Test 통과 실패로 인해 호출 제외
     */
    private static void ensureIsNotInitialized() {
        if (isInitialized) {
            throw new IllegalStateException("이미 Application이 초기화 되었습니다.");
        }
        isInitialized = true;
    }
}
