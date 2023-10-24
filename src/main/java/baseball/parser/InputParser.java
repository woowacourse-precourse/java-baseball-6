package baseball.parser;

import baseball.domain.ball.BallNumber;
import baseball.domain.game.GameStatus;
import baseball.exception.InvalidGameStatusNumberInput;
import baseball.validator.InputValidator;
import collection.Triple;
import java.util.Arrays;
import java.util.List;

public final class InputParser {

    private final InputValidator inputValidator;

    public InputParser(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Triple<BallNumber> parseBallNumbersInput(final String input) {
        inputValidator.validateNumbersInput(input);
        final List<BallNumber> numbers = toBallNumberList(input);
        return Triple.fromList(numbers);
    }

    public GameStatus parseGameStatusInput(final String input) {
        inputValidator.validateGameStatusInput(input);
        final GameStatus gameStatus = GameStatus.of(input);

        return switch (gameStatus) {
            case UNKNOWN -> throw new InvalidGameStatusNumberInput();
            default -> gameStatus;
        };
    }

    private List<BallNumber> toBallNumberList(final String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .map(BallNumber::new)
                .toList();
    }
}
