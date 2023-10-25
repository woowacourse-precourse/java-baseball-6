package baseball;

import static baseball.utils.ErrorMessages.NOT_INTEGER;
import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_DUPLICATE;
import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_INVALID_SIZE;
import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_ZERO_CONTAIN;

import baseball.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Player 클래스")
public class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123456789"})
    void 생성자는_입력값의_길이가_3이_아니라면_예외를_던진다(String input) {
        Assertions.assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PLAYER_NUMBERS_INVALID_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "755", "939"})
    void 입력값에_중복된_값이_존재하면_예외를_던진다(String input) {
        Assertions.assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PLAYER_NUMBERS_DUPLICATE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"102", "470", "039"})
    void 입력값에_0이_존재하면_예외를_던진다(String input) {
        Assertions.assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PLAYER_NUMBERS_ZERO_CONTAIN);
    }

    @ParameterizedTest
    @ValueSource(strings = {"19a", "!47", "38;"})
    void 입력값에_문자가_포함되면_예외를_던진다(String input) {
        Assertions.assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER);
    }
}
