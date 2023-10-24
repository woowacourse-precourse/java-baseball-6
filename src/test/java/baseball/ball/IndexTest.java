package baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class IndexTest {
    @Test
    @DisplayName("생성자 성공")
    void testConstructor() {
        new Index(2);
    }

    @Test
    @DisplayName("1-3 인덱스 범위를 벗어나서 실패")
    void testConstructorFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Index(5));
    }
}
