package baseball.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NumberBaseballGameTest {

    private final NumberBaseballGame game = new NumberBaseballGame();

    @Test
    void 숫자가_아닌_문자() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInput("12a"); // Invalid input with non-numeric characters
        });
    }

    @Test
    void 각_자리수에_중복된_숫자() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInput("111");
        });
    }
}