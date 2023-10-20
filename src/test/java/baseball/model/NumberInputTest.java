package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static baseball.model.enums.NumberInputErrorMessage.DUPLICATE_NUMBER;
import static baseball.model.enums.NumberInputErrorMessage.INVALID_CHARACTER;
import static baseball.model.enums.NumberInputErrorMessage.INVALID_LENGTH;

class NumberInputTest {

    @Test
    void validate_정상적인_경우() {
        // given
        String input = "123";

        // when
        NumberInput numberInput = new NumberInput(input);

        // then
    }

    @Test
    void validate_3자리가_아닌_경우() {
        // given
        String input = "1234";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LENGTH.getMessage());
    }

    @Test
    void validate_숫자가_아닌_문자가_있는_경우() {
        // given
        String input = "a12";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CHARACTER.getMessage());
    }

    @Test
    void validate_0이_섞여있는_경우() {
        // given
        String input = "120";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CHARACTER.getMessage());
    }

    @Test
    void validate_중복된_수가_있는_경우() {
        // given
        String input = "122";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER.getMessage());
    }

    @Test
    void validate_빈_문자열의_경우() {
        // given
        String input = "";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LENGTH.getMessage());
    }
}
