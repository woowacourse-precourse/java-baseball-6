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

    @Test
    @DisplayName("실패 테스트 - 플레이어가 입력한 각 자리 숫자는 1부터 9까지의 정수가 아니다.")
    void test2() {
        assertThat("012".chars()
                .filter(ch -> '1' <= ch && ch <= '9')
                .count())
                .isNotEqualTo(3);
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자는 3자리이다.")
    void test3() {
        String input = "123";

        assertThat(input.length()).isEqualTo(3);
    }
}
