package baseball.game;

import static baseball.constant.MessageConstants.NOT_RESTART_OR_EXIT;
import static baseball.game.GameStatus.EXIT;
import static baseball.game.GameStatus.RESTART;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStatusTest {

    @DisplayName("chooseStatus()에서 Restart Number인 '1'을 넣으면 GameStatus 타입인 RESTART가 반환된다.")
    @Test
    void choose_status_with_restart() {
        // given
        String validNumberString = "1";

        // when
        // then
        assertThat(GameStatus.chooseStatus(validNumberString))
                .isEqualTo(RESTART);
    }

    @DisplayName("chooseStatus()에서 Exit Number인 '2'를 넣으면 GameStatus 타입인 EXIT가 반환된다.")
    @Test
    void choose_status_with_exit() {
        // given
        String validNumberString = "2";

        // when
        // then
        assertThat(GameStatus.chooseStatus(validNumberString))
                .isEqualTo(EXIT);
    }

    @DisplayName("chooseStatus()에서 Restart Number도 Exit Number도 아닌 '5'를 넣으면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void choose_status_with_invalid() {
        // given
        String invalidNumberString = "5";

        // when
        // then
        assertThatThrownBy(() -> GameStatus.chooseStatus(invalidNumberString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidNumberString + NOT_RESTART_OR_EXIT);
    }

}
