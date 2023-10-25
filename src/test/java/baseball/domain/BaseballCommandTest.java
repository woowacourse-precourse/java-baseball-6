package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.domain.BaseballCommand.*;
import static org.assertj.core.api.Assertions.*;

class BaseballCommandTest {

    @Test
    @DisplayName("1을 입력하면 RETRY가 반환되어야 한다.")
    void getRetry() {
        assertThat(confirm("1")).isEqualTo(RETRY);
    }

    @Test
    @DisplayName("2를 입력하면 QUIT이 반환되어야 한다.")
    void getQUIT() {
        assertThat(confirm("2")).isEqualTo(QUIT);
    }

    @Test
    @DisplayName("1또는 2가 아니라면 예외가 발생해야 한다.")
    void validateNumberLength() {
        assertThatThrownBy(() -> confirm("5")).isInstanceOf(IllegalArgumentException.class);
    }
}