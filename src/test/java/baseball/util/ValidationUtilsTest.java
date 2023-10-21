package baseball.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
    @Test
    @DisplayName("숫자_1부터_9까지_검증")
    void 숫자_범위_검증() {
        boolean result = ValidationUtils.validNumber(9);
        assertThat(ValidationUtils.validNumber(1)).isTrue();
        assertThat(ValidationUtils.validNumber(9)).isTrue();
        assertThat(ValidationUtils.validNumber(0)).isFalse();
        assertThat(ValidationUtils.validNumber(10)).isFalse();
    }
}
