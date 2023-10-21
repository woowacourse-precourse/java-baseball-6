package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.GameResult;
import baseball.util.NumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Service 단위 테스트")
public class GameServiceTest {

    private GameService service;

    @BeforeEach
    void setUp() {
        service = new GameService(new TestNumberGenerator(List.of(1, 2, 3)));
        service.startGame();
    }

    @DisplayName("낫싱 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_nothing_game_result() {
        // given
        service.setPlayerBaseball(List.of(4, 5, 6));

        // when
        GameResult gameResult = service.getGameResult();

        // then
        assertThat(gameResult).isEqualTo(GameResult.nothing());
    }

    @DisplayName("3볼 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_3_ball_game_result() {
        // given
        service.setPlayerBaseball(List.of(2, 3, 1));

        // when
        GameResult gameResult = service.getGameResult();

        // then
        assertThat(gameResult).isEqualTo(GameResult.ballsAndStrikes(3, 0));
    }

    @DisplayName("2볼 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_2_ball_game_result() {
        // given
        service.setPlayerBaseball(List.of(2, 3, 4));

        // when
        GameResult gameResult = service.getGameResult();

        // then
        assertThat(gameResult).isEqualTo(GameResult.ballsAndStrikes(2, 0));
    }

    @DisplayName("1볼 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_1_ball_game_result() {
        // given
        service.setPlayerBaseball(List.of(5, 6, 1));

        // when
        GameResult gameResult = service.getGameResult();

        // then
        assertThat(gameResult).isEqualTo(GameResult.ballsAndStrikes(1, 0));
    }

    @DisplayName("3스트라이크 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_all_strike_game_result() {
        // given
        service.setPlayerBaseball(List.of(1, 2, 3));

        // when
        GameResult gameResult = service.getGameResult();

        // then
        assertThat(gameResult).isEqualTo(GameResult.allStrike());
    }

    @DisplayName("2스트라이크 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_2_strike_game_result() {
        // given
        service.setPlayerBaseball(List.of(1, 2, 4));

        // when
        GameResult gameResult = service.getGameResult();

        // then
        assertThat(gameResult).isEqualTo(GameResult.ballsAndStrikes(0, 2));
    }

    @DisplayName("1스트라이크 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_1_strike_game_result() {
        // given
        service.setPlayerBaseball(List.of(1, 4, 5));

        // when
        GameResult gameResult = service.getGameResult();

        // then
        assertThat(gameResult).isEqualTo(GameResult.ballsAndStrikes(0, 1));
    }

    @DisplayName("2볼 1스트라이크 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_2_ball_1_strike_game_result() {
        // given
        service.setPlayerBaseball(List.of(1, 3, 2));

        // when
        GameResult gameResult = service.getGameResult();
        assertThat(gameResult).isEqualTo(GameResult.ballsAndStrikes(2, 1));
    }

    @DisplayName("1볼 1스트라이크 상황일 때 맞는 결과를 리턴한다.")
    @Test
    void get_1_ball_1_strike_game_result() {
        // given
        service.setPlayerBaseball(List.of(4, 2, 1));

        // when
        GameResult gameResult = service.getGameResult();

        // then
        assertThat(gameResult).isEqualTo(GameResult.ballsAndStrikes(1, 1));
    }

    public static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> generate() {
            return numbers;
        }
    }
}
