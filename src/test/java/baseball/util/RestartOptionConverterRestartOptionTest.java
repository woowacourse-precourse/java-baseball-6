package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("UserInputValidator 클래스의 재시작 선택 유효성 검사 테스트")
public class RestartOptionConverterRestartOptionTest {

    static Stream<Arguments> validParametersForValidateAndCheckIsRestart() {
        return Stream.of(
                Arguments.of("1", true, "재시작"),
                Arguments.of("2", false, "종료")
        );
    }

    @ParameterizedTest(name = "유효한 입력값: {0} -> 예상 결과: {2}")
    @MethodSource("validParametersForValidateAndCheckIsRestart")
    @DisplayName("재시작 선택지 유효성 검사 - 유효한 입력")
    void testValidateRestartOptionByValidInput(String validInput, boolean expected, String testMessage) {
        boolean result = RestartOptionConverter.convert(validInput);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "유효하지 않은 입력값: {0}")
    @ValueSource(strings = {"3", "abc"})
    @DisplayName("재시작 선택지 유효성 검사 - 유효하지 않은 입력")
    public void testValidateRestartOptionByInvalidInput(String invalidInput) {
        assertThrows(IllegalArgumentException.class, () -> RestartOptionConverter.convert(invalidInput));
    }


}
