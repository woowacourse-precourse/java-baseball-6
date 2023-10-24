package baseball.model;


import static org.assertj.core.api.Assertions.*;

import baseball.fixture.NumberFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberTest {

    @CsvSource({"0", "10", "-3"})
    @ParameterizedTest
    void 잘못된_범위의_값으로_넘버를_만들면_예외가_발생한다(int input) {
        // then
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 같은_값으로_넘버를_만들면_같은_값으로_취급한다() {
        // given
        Number result = NumberFixture.createNumber(1);
        Number expected = NumberFixture.createNumber(1);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
