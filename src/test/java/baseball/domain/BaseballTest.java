package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTest {

    @Test
    @ValueSource(ints = {-1, 0, 10, 11, 12})
    @DisplayName("범위를 벗어난 숫자가 입력될 경우 IllegalArgumentException을 던지는지 확인")
    void validateRange(int overRangeValue) {
        assertThatThrownBy(() -> new Baseball(overRangeValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

}