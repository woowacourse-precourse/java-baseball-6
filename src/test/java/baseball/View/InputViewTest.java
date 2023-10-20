package baseball.View;

import baseball.Util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

    @Test
    @DisplayName("null 유효성검사 테스트")
    public void isNullTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> InputView.validateInput(null));
        assertEquals(Validator.NULL_OR_EMPTY_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("빈 문자열 유효성검사 테스트")
    public void isEmptyTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> InputView.validateInput(Validator.EMPTY));
        assertEquals(Validator.NULL_OR_EMPTY_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("세자리 숫자 유효성검사 테스트")
    public void isThreeDigitNumberTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> InputView.validateInput("2222"));
        assertEquals(Validator.NOT_THREE_DIGIT_NUMBER_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("숫자 중복 유효성검사 테스트")
    public void isUniqueNumberTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> InputView.validateInput("222"));
        assertEquals(Validator.NOT_UNIQUE_NUMBER_MESSAGE, exception.getMessage());
    }
}
