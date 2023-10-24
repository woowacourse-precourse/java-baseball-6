package baseball.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("UserInputValidator 클래스의 숫자 입력 유효성 검사 테스트")
public class UserInputValidatorNumbersTest {

    static Stream<Arguments> validParametersForValidateNumbersAndConvertToArray() {
        return Stream.of(
                Arguments.of("123", new int[]{1, 2, 3}),
                Arguments.of("234", new int[]{2, 3, 4})
        );
    }

    @ParameterizedTest(name = "유효한 입력값: {0} -> 예상 결과: {1}")
    @MethodSource("validParametersForValidateNumbersAndConvertToArray")
    @DisplayName("숫자 입력 유효성 검사 및 배열 변환 - 유효한 입력")
    void testValidateAndConvertNumbersByValidInput(String validInput, int[] expected) {
        int[] result = UserInputValidator.validateNumbersAndConvertToArray(validInput);

        assertArrayEquals(expected, result);
    }

    @ParameterizedTest(name = "유효하지 않은 입력값: {0}")
    @ValueSource(strings = {"abc", "ab", "12", "1234", "102", "112"})
    @DisplayName("숫자 입력 유효성 검사 및 배열 변환 - 유효하지 않은 입력")
    public void testValidateAndConvertNumbersByInvalidInput(String invalidInput) {
        assertThrows(IllegalArgumentException.class,
                () -> UserInputValidator.validateNumbersAndConvertToArray(invalidInput));
    }
}
