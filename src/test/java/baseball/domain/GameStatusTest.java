package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStatusTest {

    @DisplayName("\"1\" 또는 \"2\"일 때, 해당 GameStatus enum constant를 반환")
    @Test
    void testInputOneOrTwoReturnsGameStatus() {
        // given
        String input1 = "1";
        String input2 = "2";

        // when
        GameStatus gameStatus1 = GameStatus.of(input1);
        GameStatus gameStatus2 = GameStatus.of(input2);

        // then
        assertThat(gameStatus1).isEqualTo(GameStatus.RESTART);
        assertThat(gameStatus2).isEqualTo(GameStatus.EXIT);
    }


    @DisplayName("\"1\" 또는 \"2\"이 아닌 문자열에 해당하는 GameStatus enum constant 없으므로 예외 발생")
    @Test
    void throwIfNonOneOrTwoInput() {
        // given
        String input1 = "7";
        String input2 = "sos";

        // when
        // then
        assertThatThrownBy(() -> GameStatus.of(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 재실행 또는 종료에 대한 입력 값은 1 또는 2만 가능합니다.");

        assertThatThrownBy(() -> GameStatus.of(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 재실행 또는 종료에 대한 입력 값은 1 또는 2만 가능합니다.");
    }
}