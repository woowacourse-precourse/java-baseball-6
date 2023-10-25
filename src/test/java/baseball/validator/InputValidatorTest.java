package baseball.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import baseball.exception.InvalidBallNumbersInputException;
import baseball.exception.InvalidGameStatusNumberInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class InputValidatorTest {

    @DisplayName("GameStatus으로 1자리 숫자를 입력하면 예외가 발생하지 않는다.")
    @Test
    void validateBallNumbersInputSuccessTest() {
        // given
        final InputValidator inputValidator = new InputValidator();
        final String input1 = "123";
        final String input2 = "789";

        // when
        // then
        inputValidator.validateNumbersInput(input1);
        inputValidator.validateNumbersInput(input2);
    }

    @DisplayName("BallNumbers는 반드시 3자리 숫자를 입력해야 하며, 아니면 예외가 발생한다.")
    @Test
    void validateBallNumbersInputFailureTest() {
        // given
        final InputValidator inputValidator = new InputValidator();
        final String input1 = "";
        final String input2 = "3456";
        final String input3 = "X";

        // when
        // then
        assertThatThrownBy(
                () -> inputValidator.validateNumbersInput(input1)
        )
                .isInstanceOf(InvalidBallNumbersInputException.class)
                .hasMessage(InvalidBallNumbersInputException.INVALID_NUMBERS_INPUT_MESSAGE);

        assertThatThrownBy(
                () -> inputValidator.validateNumbersInput(input2)
        )
                .isInstanceOf(InvalidBallNumbersInputException.class)
                .hasMessage(InvalidBallNumbersInputException.INVALID_NUMBERS_INPUT_MESSAGE);

        assertThatThrownBy(
                () -> inputValidator.validateNumbersInput(input3)
        )
                .isInstanceOf(InvalidBallNumbersInputException.class)
                .hasMessage(InvalidBallNumbersInputException.INVALID_NUMBERS_INPUT_MESSAGE);

    }

    @DisplayName("GameStatus으로 1자리 숫자를 입력하면 예외가 발생하지 않는다.")
    @Test
    void validateSuccessTest() {
        // given
        final InputValidator inputValidator = new InputValidator();
        final String input1 = "1";
        final String input2 = "9";

        // when
        // then
        inputValidator.validateGameStatusInput(input1);
        inputValidator.validateGameStatusInput(input2);
    }

    @DisplayName("GameStatusInput은 반드시 1자리 숫자를 입력해야 하며, 아니면 예외가 발생한다.")
    @Test
    void validateGameStatusInputFailureTest() {
        // given
        final InputValidator inputValidator = new InputValidator();
        final String input1 = "11";
        final String input2 = "X";
        final String input3 = "";

        // when
        // then
        assertThatThrownBy(
                () -> inputValidator.validateGameStatusInput(input1)
        )
                .isInstanceOf(InvalidGameStatusNumberInputException.class)
                .hasMessage(InvalidGameStatusNumberInputException.INVALID_GAME_STATUS_INPUT_MESSAGE);

        assertThatThrownBy(
                () -> inputValidator.validateGameStatusInput(input2)
        )
                .isInstanceOf(InvalidGameStatusNumberInputException.class)
                .hasMessage(InvalidGameStatusNumberInputException.INVALID_GAME_STATUS_INPUT_MESSAGE);

        assertThatThrownBy(
                () -> inputValidator.validateGameStatusInput(input3)
        )
                .isInstanceOf(InvalidGameStatusNumberInputException.class)
                .hasMessage(InvalidGameStatusNumberInputException.INVALID_GAME_STATUS_INPUT_MESSAGE);
    }
}