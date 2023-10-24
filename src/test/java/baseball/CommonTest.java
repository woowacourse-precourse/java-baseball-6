package baseball;

import baseball.common.Common;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommonTest {

    @Test
    void inputSuccess() {
        final String input1 = "123";
        final String input2 = "594";

        Throwable thrown1 = catchThrowable(() -> Common.validateInput(input1));
        Throwable thrown2 = catchThrowable(() -> Common.validateInput(input2));

        assertThat(thrown1).doesNotThrowAnyException();
        assertThat(thrown2).doesNotThrowAnyException();
    }

    @Test
    void inputException() {
        final String input1 = "103";
        final String input2 = "1233";
        final String input3 = "abc";

        assertThatThrownBy(() -> Common.validateInput(input1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Common.validateInput(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Common.validateInput(input3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputRetrySuccess() {
        final String input1 = "1";
        final String input2 = "2";

        Throwable thrown1 = catchThrowable(() -> Common.validateRetryInput(input1));
        Throwable thrown2 = catchThrowable(() -> Common.validateRetryInput(input2));

        assertThat(thrown1).doesNotThrowAnyException();
        assertThat(thrown2).doesNotThrowAnyException();
    }

    @Test
    void inputRetryException() {
        final String input1 = "3";
        final String input2 = "11";
        final String input3 = "abc";

        assertThatThrownBy(() -> Common.validateRetryInput(input1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Common.validateRetryInput(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Common.validateRetryInput(input3)).isInstanceOf(IllegalArgumentException.class);
    }
}