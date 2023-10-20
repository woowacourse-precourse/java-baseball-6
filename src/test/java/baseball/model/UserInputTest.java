package baseball.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.view.UserInput;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class UserInputTest {


    @Test
    void 입력의_길이가_3이다() {
        assertDoesNotThrow(() -> new UserInput("123"));
        assertThrows(IllegalArgumentException.class, () -> new UserInput(""));
        assertThrows(IllegalArgumentException.class, () -> new UserInput("1234"));
        assertThrows(IllegalArgumentException.class, () -> new UserInput("ad"));
    }

    @Test
    void 입력이_숫자로만_이루어진다() {
        assertDoesNotThrow(() -> new UserInput("123"));
        assertThrows(IllegalArgumentException.class, () -> new UserInput("1a2"));
    }

    @Test
    void 입력이_숫자일때_1과_9사이_숫자다() {
        assertDoesNotThrow(() -> new UserInput("123"));
        assertThrows(IllegalArgumentException.class, () -> new UserInput("102"));
    }

    @Test
    void 입력이_숫자일때_모두_다른_숫자다() {
        assertDoesNotThrow(() -> new UserInput("123"));
        assertThrows(IllegalArgumentException.class, () -> new UserInput("112"));
    }

}