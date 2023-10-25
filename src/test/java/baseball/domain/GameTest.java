package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 게임종료_옵션_검증_없는_옵션(int option) {
        // when
        // then
        assertThatThrownBy(() -> game.isEnd(option))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.INVALID_OPTION_NUMBER.getMessage());
    }

    @Test
    void 게임종료_옵션_검증_재시작() {
        // given
        int option = 1;

        // when
        boolean result = game.isEnd(option);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 게임종료_옵션_검증_종료() {
        // given
        int option = 2;

        // when
        boolean result = game.isEnd(option);

        // then
        assertThat(result).isTrue();
    }
}
