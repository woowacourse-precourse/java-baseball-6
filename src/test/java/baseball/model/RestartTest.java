package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestartTest {

    Restart restart;

    @Test
    @DisplayName("재시작_값이_공백일때_테스트")
    public void blankTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "";
            restart = new Restart(input);
        }, "입력값이 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("1이나2_이외값_테스트")
    public void optionsTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "a";
            restart = new Restart(input);
        }, "플레이어는 1이나 2 이외의 값을 입력할 수 없습니다.");
    }
}