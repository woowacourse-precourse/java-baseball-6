package baseball.modules.console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Nested
@DisplayName("User Input - BaseBall Number")
class BaseballInputTest {

    @Test
    @DisplayName("사용자가 입력 양식에 맞게 입력을 했을 경우")
    public void checkValidationUserInput_Success() {
        assertThat(new BaseballInput("123")).isEqualTo(new BaseballInput("123"));
    }

    @ParameterizedTest
    @MethodSource("userInput_Exception_NotNumeric")
    @DisplayName("사용자가 입력 양식에 맞지 않게 입력한 경우 - 숫자가 아닌 문자")
    public void checkValidationUserInput_Exception_NotNumeric(final String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BaseballInput(input));
    }

    static Stream<Arguments> userInput_Exception_NotNumeric() {
        return Stream.of(
                arguments("1A2"),
                arguments("1.2"),
                arguments("1)2"),
                arguments("1 2"),
                arguments("   ")
        );
    }

    @ParameterizedTest
    @MethodSource("userInput_Exception_InvalidLength")
    @DisplayName("사용자가 입력 양식에 맞지 않게 입력한 경우 - 3자리가 아님")
    public void checkValidationUserInput_Exception_InvalidLength(final String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BaseballInput(input));
    }

    static Stream<Arguments> userInput_Exception_InvalidLength() {
        return Stream.of(
                arguments("12"),
                arguments("1234"),
                arguments("1"),
                arguments("")
        );
    }

    @ParameterizedTest
    @MethodSource("userInput_Exception_Duplicate")
    @DisplayName("사용자가 입력 양식에 맞지 않게 입력한 경우 - 중복된 숫자를 입력")
    public void checkValidationUserInput_Exception_Duplicate(final String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BaseballInput(input));
    }

    static Stream<Arguments> userInput_Exception_Duplicate() {
        return Stream.of(
                arguments("122"),
                arguments("113"),
                arguments("111"),
                arguments("511")
        );
    }

    @ParameterizedTest
    @MethodSource("userInput_Exception_InvalidRange")
    @DisplayName("사용자가 입력 양식에 맞지 않게 입력한 경우 - 범위에 맞지 않은 숫자 입력")
    public void checkValidationUserInput_Exception_InvalidRange(final String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BaseballInput(input));
    }

    static Stream<Arguments> userInput_Exception_InvalidRange() {
        return Stream.of(
                arguments("012"),
                arguments("103"),
                arguments("190")
        );
    }
}