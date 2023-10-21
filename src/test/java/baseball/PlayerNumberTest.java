package baseball;

import baseball.domain.PlayerNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerNumberTest {

    @Test
    @DisplayName("플레이어 입력값이 숫자가 아닌 경우 예외 발생")
    void 숫자아닌_예외(){
        assertThrowException("문자문자");
    }
    @Test
    @DisplayName("플레이어 숫자 길이가 3이 아닌 경우 예외 발생")
    void 숫자길이3아님_예외(){
        assertThrowException("1234");
    }
    @Test
    @DisplayName("플레이어 숫자가 서로 다른 수가 아닌 경우 예외 발생")
    void 서로다른수아님_예외(){
        assertThrowException("122");
    }
    @Test
    @DisplayName("플레이서 숫자가 1에서 9 사이가 아닌 경우 예외 발생")
    void 일부터구사이아님_예외(){
        assertThrowException("120");
    }

    private static void assertThrowException(String playerInput) {
        PlayerNumber playerNumber = new PlayerNumber();
        Assertions.assertThatThrownBy(() ->
                playerNumber.updatePlayerNumbers(playerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
