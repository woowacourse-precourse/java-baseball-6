package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContinueModeNumberValidatorTest {

    private InputValidator continueModeNumberValidator;

    @BeforeEach
    public void setUp() {
        continueModeNumberValidator = new ContinueModeNumberValidator();
    }

    @Test
    public void 올바른_추측값_검증_테스트() {
        String continueInput = "1";
        assertDoesNotThrow(() -> continueModeNumberValidator.validate(continueInput));
        String exitInput = "2";
        assertDoesNotThrow(() -> continueModeNumberValidator.validate(exitInput));
    }

    @Test
    public void 모드값_오류_검증_테스트() {
        String input = "3";
        assertThrows(IllegalArgumentException.class, () -> continueModeNumberValidator.validate(input));
    }

    @Test
    public void 타입_오류_추측값_검증_테스트() {
        String input = "a";
        assertThrows(IllegalArgumentException.class, () -> continueModeNumberValidator.validate(input));
    }

    @Test
    public void 길이_오류_추측값_검증_테스트() {
        String input = "12311";
        assertThrows(IllegalArgumentException.class, () -> continueModeNumberValidator.validate(input));
    }

}