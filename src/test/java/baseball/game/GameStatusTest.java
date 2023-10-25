package baseball.game;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameStatusTest {

    @ParameterizedTest
    @ValueSource(strings = {"0, 3"})
    void invalidRestart(String invalidValue) {
        // when
        assertThrows(IllegalArgumentException.class, () -> GameStatus.of(invalidValue));
    }
}