package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

    @Test
    void 문자열_숫자_검증() {
        assertThat(ValidationUtils.isNumber("number")).isFalse();
        assertThat(ValidationUtils.isNumber("10s")).isFalse();
        assertThat(ValidationUtils.isNumber("-1")).isTrue();
        assertThat(ValidationUtils.isNumber("0")).isTrue();
        assertThat(ValidationUtils.isNumber("1")).isTrue();
    }
}
