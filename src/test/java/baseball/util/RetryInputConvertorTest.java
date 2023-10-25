package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RetryInputConvertorTest {

    @Test
    void 플레이어의_입력을_숫자로_변환할_수_있다() {
        String playerInput = "1";
        int retryInput = RetryInputConvertor.convertRetryInput(playerInput);

        assertThat(retryInput).isEqualTo(1);
    }

    @Test
    void 플레이어_입력의_길이가_1_초과인_경우_예외를_발생시킨다() {
        String playerInput = "12";

        assertThatThrownBy(
            () -> RetryInputConvertor.convertRetryInput(playerInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"f", "a", "i", "l"})
    void 플레이어의_입력에_숫자가_아닌_입력이_있는_경우_예외를_발생시킨다(String playerInput) {

        assertThatThrownBy(
            () -> RetryInputConvertor
                .convertRetryInput(playerInput))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
