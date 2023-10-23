package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @DisplayName("1-9사이의 한 자리 숫자가 입력되면 Ball이 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "9"})
    public void from(String givenValue) {
        Ball ball = assertDoesNotThrow(() -> Ball.from(givenValue));

        assertThat(ball.number()).isEqualTo(Integer.parseInt(givenValue));
    }

    @DisplayName("숫자가 아닌 문자나 2자리 이상 숫자, 0이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "$a", "53", "0", ""})
    public void invalid_from(String givenValue) {
        assertThatThrownBy(() -> Ball.from(givenValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ball이 가진 number를 기준으로 동등성 비교가 이루어진다")
    @Test
    public void equals() {
        Ball three = Ball.from("3");

        assertThat(three.equals(Ball.from("3"))).isTrue();
        assertThat(three.equals(Ball.from("4"))).isFalse();
    }

}
