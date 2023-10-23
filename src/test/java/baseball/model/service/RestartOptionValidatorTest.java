package baseball.model.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartOptionValidatorTest {
    private RestartOptionValidator restartOptionValidator;

    @BeforeEach
    void setUp() {
        restartOptionValidator = new RestartOptionValidatorImp();
    }

    @ParameterizedTest
    @DisplayName("숫자 외 입력, 한 자리 외 입력, 범위 외 입력에 따라 예외가 발생합니다.")
    @ValueSource(strings = {"A", "12", "3"})
    void 사용자_재시작_숫자_입력_예외(String inputOption) {
        assertThrows(IllegalArgumentException.class, () -> {
            restartOptionValidator.validateRestartOption(inputOption);
        });
    }
}