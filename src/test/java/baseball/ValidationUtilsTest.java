package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.tdd.ValidationUtils;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
    @Test
    void 야구_숫자_1_9_검증() {
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(0)).isFalse();
        assertThat(ValidationUtils.validNo(10)).isFalse();
    }
}
