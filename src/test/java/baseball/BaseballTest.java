package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {

    @ParameterizedTest
    @DisplayName("1-9 이외에 숫자로는 Baseball 을 생성할 수 없다")
    @ValueSource(ints = {0, 10, -1, -100, 1000})
    public void validateBaseballTest(int input) {
        // given, when, then
        assertThatThrownBy(() -> new Baseball(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Baseball 의 ballNumber 값이 같다면 동일한 객체로 인식된다")
    public void equalsTest() {
        // given
        Baseball ball = new Baseball(1);
        Baseball otherBall = new Baseball(1);

        // when, then
        Assertions.assertThat(ball).isEqualTo(otherBall);
    }

}