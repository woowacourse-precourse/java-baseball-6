package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    @DisplayName("낫싱 테스트")
    void nothing_test() {
        List<Integer> balls2 = List.of(4, 5, 6);
        RandomBalls randomBalls = new RandomBalls(balls2);

        List<Integer> balls1 = List.of(1, 2, 3);
        UserBalls userBalls = new UserBalls(balls1);

        GameResult gameResult = new GameResult(0, 0);

        assertThat(GameResult.compareBalls(randomBalls, userBalls)).usingRecursiveComparison().isEqualTo(gameResult);
        assertEquals(gameResult.getResultMessage(), "낫싱");
    }

    @Test
    @DisplayName("1볼 1스트라이크 테스트")
    void ball_1_strike_1_test() {
        List<Integer> balls2 = List.of(4, 5, 6);
        RandomBalls randomBalls = new RandomBalls(balls2);

        List<Integer> balls1 = List.of(4, 6, 3);
        UserBalls userBalls = new UserBalls(balls1);

        GameResult gameResult = new GameResult(1, 1);

        assertThat(GameResult.compareBalls(randomBalls, userBalls)).usingRecursiveComparison().isEqualTo(gameResult);
        assertEquals(gameResult.getResultMessage(), "1볼 1스트라이크");
    }

    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void ball_2_strike_1_test() {
        List<Integer> balls2 = List.of(4, 6, 3);
        RandomBalls randomBalls = new RandomBalls(balls2);

        List<Integer> balls1 = List.of(3, 6, 4);
        UserBalls userBalls = new UserBalls(balls1);

        GameResult gameResult = new GameResult(1, 2);

        assertThat(GameResult.compareBalls(randomBalls, userBalls)).usingRecursiveComparison().isEqualTo(gameResult);
        assertEquals(gameResult.getResultMessage(), "2볼 1스트라이크");
    }

    @Test
    @DisplayName("올 스트라이크 테스트")
    void all_strike_test() {
        List<Integer> balls2 = List.of(6, 7, 8);
        RandomBalls randomBalls = new RandomBalls(balls2);

        List<Integer> balls1 = List.of(6, 7, 8);
        UserBalls userBalls = new UserBalls(balls1);

        GameResult gameResult = new GameResult(3, 0);

        assertThat(GameResult.compareBalls(randomBalls, userBalls)).usingRecursiveComparison().isEqualTo(gameResult);
        assertEquals(gameResult.getResultMessage(), "3스트라이크");
        assertEquals(gameResult.isAllStrikes(), true);
    }
}