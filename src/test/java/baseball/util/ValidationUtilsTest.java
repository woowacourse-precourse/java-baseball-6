package baseball.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
    @Test
    @DisplayName("숫자가 아니면 예외")
    void 숫자_변환_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ValidationUtils.validUserNumber("일이삼"))
                .withMessage("입력은 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("3개를 입력하지 않은 경우 예외")
    void 세자리_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ValidationUtils.validUserNumber("7282"))
                .withMessage("숫자는 세자리만 입력 가능합니다.");
    }

    @Test
    @DisplayName("숫자가 1부터 9 사이의 값이 아니면 예외")
    void 범위내_숫자_껌증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ValidationUtils.validUserNumber("043"))
                .withMessage("숫자는 1부터 9까지만 입력이 가능합니다.");
    }
}
