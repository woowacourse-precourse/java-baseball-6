package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerNumbersTest {
    @Test
    @DisplayName("플레이어 입력에 중복 숫자가 있으면 예외가 발생한다.")
    void 중복테스트_예외() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerNumbers(List.of(1, 2, 2)));
    }

    @Test
    @DisplayName("플레이어 입력이 4개이면 예외가 발생한다.")
    void 개수_초과_예외_O() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerNumbers(List.of(1, 2, 3, 4)));
    }

    @Test
    @DisplayName("플레이어 입력이 2개면 예외가 발생한다.")
    void 개수_미만_예외_O() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerNumbers(List.of(1, 2)));
    }

    @Test
    @DisplayName("플레이어 입력이 3개이고, 중복된 것이 없으먄 예외가 발생하지 않는다.")
    void 개수_정상_O() {
        PlayerNumbers numbers = new PlayerNumbers(List.of(1, 2, 3));
        assertDoesNotThrow(() -> new PlayerNumbers(List.of(1, 2, 3)));
    }


}