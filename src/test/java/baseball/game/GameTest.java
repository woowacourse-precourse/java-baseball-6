package baseball.game;

import baseball.error.ErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @ValueSource(strings = {"a12", "1b2", "56c", "qw1", "q2소", "9cz", "zxc"})
    @ParameterizedTest
    void 숫자_외에_다른_것_입력(String input) {
        //given, when
        Game game = new Game();

        //then
        assertThatThrownBy(() -> game.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DIGIT_ERROR.message);
    }

    @ValueSource(strings = {"1", "12", "1234", "12345", "123456"})
    @ParameterizedTest
    void 숫자_개수가_다를_때(String input) {
        //given, when
        Game game = new Game();

        //then
        assertThatThrownBy(() -> game.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.SIZE_ERROR.message);
    }

    @ValueSource(strings = {"112", "151", "122", "333"})
    @ParameterizedTest
    void 중복된_숫자가_포함될_때(String input) {
        //given, when
        Game game = new Game();

        //then
        assertThatThrownBy(() -> game.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATION_ERROR.message);
    }
}