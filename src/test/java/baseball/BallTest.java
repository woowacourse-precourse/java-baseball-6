package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import baseball.domain.Ball;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void from는_올바르지_않은_범위값을_받는_경우_Exception을_반환한다(int number) {
        assertThatThrownBy(() -> Ball.from(1, number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력은 0을 포함할 수 없슴니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void from는_올바른_범위값을_받는_경우_Exception을_반환하지_않고_올바른_객체를_생성한다(int number) {
        assertDoesNotThrow(() -> Ball.from(1, number));
    }
}
