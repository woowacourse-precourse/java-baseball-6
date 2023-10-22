package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerInputTest {
    @Test
    @DisplayName("플레이어가 입력한 각 자리 숫자는 1부터 9까지의 정수이다.")
    void test1() {
        assertThat("123".chars()
                .filter(ch -> '1' > ch || ch > '9' ))
                .isEmpty();
    }
}
