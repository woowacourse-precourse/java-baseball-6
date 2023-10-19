package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class GameStatusTest {

  @DisplayName("String 1 또는 2로 GameStatus enum constant를 가져올 수 있다")
  @Test
  void gameStatusSuccess() {
    // given
    // when
    final GameStatus status = GameStatus.of("1");
    final GameStatus status2 = GameStatus.of("2");

    // then
    assertThat(status).isEqualTo(GameStatus.REPLAY);
    assertThat(status2).isEqualTo(GameStatus.EXIT);
  }

  @DisplayName("String 1 또는 2 외의 값으로 GameStatus enum constant를 생성하면 예외 발생")
  @Test
  void gameStatusFailure() {
    // given
    // when
    // then
    assertThatThrownBy(() -> GameStatus.of("3"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("GameStatus는 반드시 1, 2 중 하나를 입력해서 만들 수 있습니다.");
  }
}
