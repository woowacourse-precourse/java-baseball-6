package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    private GameResult gameResult = new GameResult();

    @Test
    @DisplayName("3스트라이크 테스트 - 게임 종료")
    void strikeOrBall_3strike() {
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> baseballNumbers = List.of(1, 2, 3);

        gameResult.strikeOrBall(baseballNumbers, user);

        assertThat(gameResult.isWin()).isEqualTo(true);
    }

    @Test
    @DisplayName("스트라이크, 볼 테스트 - 1스트라이크 2볼")
    void strikeOrBall_1strike_2ball() {
        List<Integer> user = List.of(1, 3, 2);
        List<Integer> baseballNumbers = List.of(1, 2, 3);

        gameResult.strikeOrBall(baseballNumbers, user);

        assertThat(gameResult.isWin()).isEqualTo(false);
        assertThat(gameResult.toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("스트라이크, 볼 테스트 테스트 - 2볼")
    void strikeOrBall() {
        List<Integer> user = List.of(9, 3, 2);
        List<Integer> baseballNumbers = List.of(1, 2, 3);

        gameResult.strikeOrBall(baseballNumbers, user);

        assertThat(gameResult.isWin()).isEqualTo(false);
        assertThat(gameResult.toString()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("스트라이크, 볼 테스트 테스트 - 연속 테스트")
    void strikeOrBall_continue() {
        List<Integer> user = List.of(2, 8, 1);
        List<Integer> baseballNumbers = List.of(1, 2, 3);

        gameResult.strikeOrBall(baseballNumbers, user);

        assertThat(gameResult.isWin()).isEqualTo(false);
        assertThat(gameResult.toString()).isEqualTo("2볼");

        user = List.of(1, 9, 8);

        gameResult.strikeOrBall(baseballNumbers, user);

        assertThat(gameResult.isWin()).isEqualTo(false);
        assertThat(gameResult.toString()).isEqualTo("1스트라이크");
    }
}