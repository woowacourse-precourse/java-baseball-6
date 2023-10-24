package baseball.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameNumberTest {

    @Test
    void 문자를_입력한_경우() {
        assertThatThrownBy(() -> new GameNumber("a23"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new GameNumber("1b3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new GameNumber("12c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputContainsZero() {
        assertThatThrownBy(() -> new GameNumber("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}