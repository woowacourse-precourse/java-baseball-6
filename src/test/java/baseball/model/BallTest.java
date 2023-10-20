package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @DisplayName("Ball 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void createBall(int num) throws Exception {
        //when
        Ball ball = new Ball(num);

        //then
        assertThat(ball.getNum()).isEqualTo(num);
    }

    @DisplayName("Ball 생성 예외 : 1-9 범위의 숫자가 아닐때 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    public void createBall_exception_invalid_num(int illegalNumber) throws Exception {
        //when, then
        assertThatThrownBy(() -> new Ball(illegalNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1-9사이의 숫자를 입력해야 합니다.");
    }
}
