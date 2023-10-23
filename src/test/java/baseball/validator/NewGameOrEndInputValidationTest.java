package baseball.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NewGameOrEndInputValidationTest {

    NewGameOrEndInputValidation newGameOrEndInputValidation = new NewGameOrEndInputValidation();

    @Test
    @DisplayName("1. 숫자 판별 2. 1 혹은 2인지 판별")
    void validate() {
        Throwable isNumericException = assertThrows(
                IllegalArgumentException.class,
                () -> newGameOrEndInputValidation.validate(" ")
        );
        assertEquals("숫자가 아닌 값이 포함되어 있습니다.", isNumericException.getMessage());

        Throwable isValueOneOrTwoException = assertThrows(
                IllegalArgumentException.class,
                () -> newGameOrEndInputValidation.validate("3")
        );
        assertEquals("1과 2중 입력해야 합니다.", isValueOneOrTwoException.getMessage());
    }
}