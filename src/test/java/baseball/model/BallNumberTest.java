package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {
    @ParameterizedTest
    @CsvSource({"1","9"})
    @DisplayName("한 자리 수를 생성한다.")
    void of(int value) {

        BallNumber sut = BallNumber.of(value);

        assertThat(sut).isEqualTo(BallNumber.of(value));
    }

    @ParameterizedTest
    @CsvSource({"0","10"})
    @DisplayName("1~9만큼의 수를 벗어날 시 예외 발생")
    void ofException(int value) {
        assertThatThrownBy(
                () -> {
                    BallNumber sut = BallNumber.of(value);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 범위는 1부터 9까지만 허용");
    }

}