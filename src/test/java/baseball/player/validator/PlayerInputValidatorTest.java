package baseball.player.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInputValidatorTest {
    PlayerInputValidator playerInputValidator = PlayerInputValidator.VALIDATOR;

    @Test
    void only_number() {
        assertThrows(IllegalArgumentException.class, () -> {
            playerInputValidator.validateInput("abc");
        });
    }

    @Test
    void only_three_digit() {
        assertThrows(IllegalArgumentException.class, () -> {
            playerInputValidator.validateInput("1234");
        });
    }

    @Test
    void no_duplicate() {
        assertThrows(IllegalArgumentException.class, () -> {
            playerInputValidator.validateInput("112");
        });
    }
}