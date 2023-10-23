package baseball.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberInputValidationTest {

    private final BaseballNumberInputValidation baseballNumberInputValidation = new BaseballNumberInputValidation();

    @Test
    @DisplayName("1. 숫자 판별 2. 세 자리 판별 3. 1에서 9사이 판별 4. 중복 값 판별")
    void validate() {
        Throwable isNumericException = assertThrows(
                IllegalArgumentException.class,
                () -> baseballNumberInputValidation.validate(" ")
        );
        assertEquals("숫자가 아닌 값이 포함되어 있습니다.", isNumericException.getMessage());

        Throwable isTripleDigitException = assertThrows(
                IllegalArgumentException.class,
                () -> baseballNumberInputValidation.validate("1234")
        );
        assertEquals("세 자리의 입력값이 아닙니다.", isTripleDigitException.getMessage());

        Throwable isValidDigitRangeException = assertThrows(
                IllegalArgumentException.class,
                () -> baseballNumberInputValidation.validate("100")
        );
        assertEquals("1에서 9사이가 아닌 값이 포함되어 있습니다.", isValidDigitRangeException.getMessage());

        Throwable hasNoDuplicatesException = assertThrows(
                IllegalArgumentException.class,
                () -> baseballNumberInputValidation.validate("122")
        );
        assertEquals("중복된 값이 존재합니다.", hasNoDuplicatesException.getMessage());
    }
}