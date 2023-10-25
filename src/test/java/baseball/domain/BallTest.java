package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @DisplayName("1-9사이의 한 자리 문자열이 입력되면 Ball이 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "9"})
    void from(String stringNumber) {
        Ball ball = assertDoesNotThrow(() -> Ball.from(stringNumber));

        assertThat(ball.number()).isEqualTo(Integer.parseInt(stringNumber));
    }

    @DisplayName("숫자가 아니거나 1-9 범위 밖의 문자열이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "$a", "53", "0", "-1", "-2", ""})
    void invalid_from(String stringNumber) {
        assertThatThrownBy(() -> Ball.from(stringNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1-9사이의 숫자가 입력되면 Ball이 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9})
    void from(Integer number) {
        Ball ball = assertDoesNotThrow(() -> Ball.from(number));

        assertThat(ball.number()).isEqualTo(number);
    }

    @DisplayName("1-9 범위를 벗어나는 숫자가 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {53, 0, -1, -2})
    void invalid_from(Integer number) {
        assertThatThrownBy(() -> Ball.from(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ball 생성 시 캐싱된 인스턴스가 반환된다")
    @Test
    void instanceCaching() {
        assertThat(Ball.from(3)).isSameAs(Ball.from(3));
        assertThat(Ball.from(4)).isSameAs(Ball.from("4"));
    }

    @DisplayName("Ball이 가진 number를 기준으로 동등성 비교가 이루어진다")
    @Test
    void equals() {
        Ball three = Ball.from("3");

        assertThat(three.equals(Ball.from("3"))).isTrue();
        assertThat(three.equals(Ball.from("4"))).isFalse();
    }

}
