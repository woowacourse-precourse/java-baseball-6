package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberTest {

    @Test
    @DisplayName("Number객체 생성 검증 성공")
    void Number객체_생성_검증_성공() {
        assertThat(Number.from(1)).isInstanceOf(Number.class);
    }
    @Test
    @DisplayName("Number객체 생성 검증 실패")
    void Number객체_생성_검증_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            Number.from("1");
        });
    }
}
