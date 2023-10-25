package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void 게임종료_옵션_검증_0_실패() {
        // given
        int option = 0;

        // when
        // then
        assertThatThrownBy(() -> game.isEnd(option))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.INVALID_OPTION_NUMBER.getMessage());
    }

    @Test
    void 게임종료_옵션_검증_3_실패() {
        // given
        int option = 3;

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
