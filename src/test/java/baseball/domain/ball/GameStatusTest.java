package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.game.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class GameStatusTest {

    @DisplayName("String 1 또는 2로 GameStatus enum constant를 가져올 수 있다")
    @Test
    void gameStatusSuccess() {
        // given
        final String input1 = "1";
        final String input2 = "2";

        // when
        final GameStatus status1 = GameStatus.of(input1);
        final GameStatus status2 = GameStatus.of(input2);

        // then
        assertThat(status1).isEqualTo(GameStatus.REPLAY);
        assertThat(status2).isEqualTo(GameStatus.EXIT);
    }

    @DisplayName("String 1 또는 2 외의 값으로 GameStatus enum constant를 생성하면 UNKNOWN 반환")
    @Test
    void gameStatusFailure() {
        // given
        final String input = "3";

        // when
        final GameStatus gameStatus = GameStatus.of(input);

        // then
        assertThat(gameStatus).isEqualTo(GameStatus.UNKNOWN);
    }
}
