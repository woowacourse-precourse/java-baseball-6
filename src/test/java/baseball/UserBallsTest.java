package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserBallsTest {

    @Test
    @DisplayName("잘못된 입력 값에 대한 예외 테스트")
    void make_user_balls_exception_test() {
        // given
        String userInput = "6589";

        // when && then
        assertThatThrownBy(() -> UserBalls.makeUserBalls(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("각 인덱스에 해당하는 숫자 제대로 가져 오는지 테스트")
    void get_ball_test() {
        // given
        List<Integer> balls = List.of(1, 2, 3);
        UserBalls userBalls = new UserBalls(balls);

        // when && then
        assertEquals(userBalls.getBall(0), 1);
        assertEquals(userBalls.getBall(1), 2);
        assertEquals(userBalls.getBall(2), 3);
    }

    @Test
    @DisplayName("볼 판단을 위한 contains 메서드 테스트")
    void contains_test() {
        // given
        List<Integer> balls = List.of(1, 2, 3);
        UserBalls userBalls = new UserBalls(balls);

        assertEquals(userBalls.contains(1), true);
        assertEquals(userBalls.contains(2), true);
        assertEquals(userBalls.contains(3), true);
        assertEquals(userBalls.contains(4), false);
    }
}