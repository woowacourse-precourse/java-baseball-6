package baseball.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    void create() {
        // given
        Number number = new Number(1);

        // then
        assertThat(number).isEqualTo(new Number("1"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "A"})
    void createException(String value) {
        // then
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
