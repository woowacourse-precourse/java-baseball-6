package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuessedNumberValidatorTest {

    private InputValidator guessedNumberValidator;

    @BeforeEach
    public void setUp() {
        guessedNumberValidator = new GuessedNumberValidator();
    }

    @Test
    public void 올바른_추측값_검증_테스트() {
        String input = "123";
        assertDoesNotThrow(() -> guessedNumberValidator.validate(input));
    }

    @Test
    public void 중복_있는_추측값_검증_테스트() {
        String input = "113";
        assertThrows(IllegalArgumentException.class, () -> guessedNumberValidator.validate(input));
    }

    @Test
    public void 타입_오류_추측값_검증_테스트() {
        String input = "a23";
        assertThrows(IllegalArgumentException.class, () -> guessedNumberValidator.validate(input));
    }

    @Test
    public void 길이_오류_추측값_검증_테스트() {
        String input = "12311";
        assertThrows(IllegalArgumentException.class, () -> guessedNumberValidator.validate(input));
    }

}