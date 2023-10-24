package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomBallsTest {

    @Test
    @DisplayName("랜덤 숫자 개수 일치 테스트")
    void check_random_ball_size_test() {
        // given
        RandomBalls randomBalls = RandomBalls.makeRandomBalls();

        // when && then
        assertEquals(randomBalls.getSize(), RandomBalls.BALLS_COUNT);
    }

    @Test
    @DisplayName("각 인덱스에 해당하는 숫자 제대로 가져 오는지 테스트")
    void get_ball_test() {
        // given
        List<Integer> balls = List.of(1, 2, 3);
        RandomBalls randomBalls = new RandomBalls(balls);

        // when && then
        assertEquals(randomBalls.getBall(0), 1);
        assertEquals(randomBalls.getBall(1), 2);
        assertEquals(randomBalls.getBall(2), 3);
    }
}