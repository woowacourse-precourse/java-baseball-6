package baseball.global.validator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private final InputValidator validator;
    InputValidatorTest(){
        validator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12a", "1a2", "a12", "테스트"})
    @DisplayName("숫자 이외의 값 입력에 대한 예외 처리 테스트")
    void validateInputNumericTest(String playerInput) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateBaseballNumberInput(playerInput),"숫자 이외에는 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234"})
    @DisplayName("3자리가 아닌 숫자 입력에 대한 예외 처리 테스트")
    void validateInputSizeTest(String playerInput) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateBaseballNumberInput(playerInput),"입력한 숫자의 자릿수가 일치하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "112", "122", "222"})
    @DisplayName("중복 입력에 대한 예외 처리 테스트")
    void validateInputDistinctTest(String playerInput) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateBaseballNumberInput(playerInput),"숫자를 중복하여 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "7", "11", "333", "test", "테스트"})
    @DisplayName("GameCode 클래스가 관리하는 코드 이외의 값 입력에 대한 예외 처리 테스트")
    void validateIsExistGameCodeTest(String playerInput) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateBaseballNumberInput(playerInput),"정의되지 않은 입력값입니다.");
    }
}