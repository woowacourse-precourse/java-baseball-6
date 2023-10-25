package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.model.Numbers;
import baseball.util.constants.ExceptionMessages;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("UserInputValidator 클래스의 숫자 입력 유효성 검사 테스트")
public class UserInputValidatorNumbersTest {

    static Stream<Arguments> validParametersForValidateNumbersAndConvertToArray() {

        return Stream.of(
                Arguments.of("123", Numbers.create(new int[]{1, 2, 3})),
                Arguments.of("234", Numbers.create(new int[]{2, 3, 4}))
        );
    }

    static String getExceptionMessage(String message, String input) {

        return NumbersConverter.ILLEGAL_INPUT_EXCEPTION_MESSAGE.formatted(message, input);
    }

    static Stream<Arguments> invalidParametersForNumbersValidate() {
        return Stream.of(
                Arguments.of("abc", getExceptionMessage(ExceptionMessages.NUMBERS_OUT_OF_RANGE, "abc")),
                Arguments.of("ab", getExceptionMessage(ExceptionMessages.NUMBERS_WRONG_LENGTH, "ab")),
                Arguments.of("12", getExceptionMessage(ExceptionMessages.NUMBERS_WRONG_LENGTH, "12")),
                Arguments.of("1234", getExceptionMessage(ExceptionMessages.NUMBERS_WRONG_LENGTH, "1234")),
                Arguments.of("102", getExceptionMessage(ExceptionMessages.NUMBERS_OUT_OF_RANGE, "102")),
                Arguments.of("112", getExceptionMessage(ExceptionMessages.NUMBERS_DUPLICATED_MESSAGE, "112"))
        );
    }

    @ParameterizedTest(name = "유효한 입력값: {0} -> 예상 결과: {1}")
    @MethodSource("validParametersForValidateNumbersAndConvertToArray")
    @DisplayName("숫자 입력 유효성 검사 및 배열 변환 - 유효한 입력")
    void testValidateAndConvertNumbersByValidInput(String validInput, Numbers expected) {
        Numbers result = NumbersConverter.convert(validInput);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "유효하지 않은 입력값: {0} -> {1}")
    @MethodSource("invalidParametersForNumbersValidate")
//    @ValueSource(strings = {"abc", "ab", "12", "1234", "102", "112"})
    @DisplayName("숫자 입력 유효성 검사 및 배열 변환 - 유효하지 않은 입력")
    public void testValidateAndConvertNumbersByInvalidInput(String invalidInput, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> NumbersConverter.convert(invalidInput));
        assertEquals(expectedMessage, exception.getMessage());
    }
}
