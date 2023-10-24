package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import baseball.utills.ValidateUtils;

public class ValidationUtilsTest {

    @Test
    @DisplayName("야구 숫자 1,9 검증")
    void 야구_숫자_1_9_검증() {
        assertThat(ValidateUtils.validNo(9)).isTrue();
        assertThat(ValidateUtils.validNo(1)).isTrue();
        assertThat(ValidateUtils.validNo(0)).isFalse();
        assertThat(ValidateUtils.validNo(10)).isFalse();
    }
}
