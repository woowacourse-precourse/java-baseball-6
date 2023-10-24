package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameStatusTest {

    @Test
    @DisplayName("GameStatus 는 1 또는 2만 파라미터로 입력받아 생성할 수 있다")
    public void createGameStatusTest() {
        // given, when
        GameStatus inProgress = GameStatus.of(1);
        GameStatus ended = GameStatus.of(2);

        // then
        Assertions.assertThat(inProgress).isEqualTo(GameStatus.IN_PROGRESS);
        Assertions.assertThat(ended).isEqualTo(GameStatus.ENDED);
    }

    @ParameterizedTest
    @DisplayName("1과 2를 제외한 나머지 숫자 값을 입력받으면 IllegalArgumentException 을 발생시킨다")
    @ValueSource(ints = {0, 3, 4, 5, 6, 7, 8, 9})
    public void badInputForCreateGameStatusTest(int option) {
        // given, when, then
        Assertions.assertThatThrownBy(() -> GameStatus.of(option))
                .isInstanceOf(IllegalArgumentException.class);
    }
}