package baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    @DisplayName("생성 성공")
    void testConstructor() {
        new Number(8);
    }

    @Test
    @DisplayName("1-9 범위를 벗어나 생성 실패")
    void testConstructorFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Number(0));
    }
}
