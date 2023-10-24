package baseball.Utils;

import baseball.Util.Validator;
import baseball.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    @DisplayName("null 유효성검사 테스트")
    public void isNullTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.isNullOrEmpty(null));
        assertEquals(Validator.NULL_OR_EMPTY_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("빈 문자열 유효성검사 테스트")
    public void isEmptyTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.isNullOrEmpty(Validator.EMPTY));
        assertEquals(Validator.NULL_OR_EMPTY_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("세자리 숫자 유효성검사 테스트")
    public void isThreeDigitNumberTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.isThreeDigitNumber("2222"));
        assertEquals(Validator.NOT_THREE_DIGIT_NUMBER_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("숫자 중복 유효성검사 테스트")
    public void isUniqueNumberTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.isUniqueNumber("222"));
        assertEquals(Validator.NOT_UNIQUE_NUMBER_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("1 혹은 2 유효성테스트")
    public void isOneOrTwoTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.isOneOrTwo("3"));
        assertEquals(Validator.NOT_ONE_OR_TWO, exception.getMessage());
    }
}
