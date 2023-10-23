package baseball.model.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNumbersValidatorTest {
    private PlayerNumbersValidator playerNumbersValidator;

    @BeforeEach
    void setUp() {
        playerNumbersValidator = new PlayerNumbersValidatorImp();
    }

    @ParameterizedTest
    @DisplayName("숫자 외 입력, 세 자리 외 입력, 범위 외 입력, 중복 수 입력에 따라 예외가 발생합니다.")
    @ValueSource(strings = {"12A", "12", "120", "122"})
    void 사용자_게임_숫자_입력_예외(String inputNumbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            playerNumbersValidator.validatePlayerNumbers(inputNumbers);
        });
    }
}