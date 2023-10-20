package baseball.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerServiceTest {
    
    private final PlayerService playerService = new PlayerService();
    
    @Test
    @DisplayName("사용자가 3자리 숫자를 올바르게 입력한 경우")
    void success() {
        playerService.validate("123");
    }
    
    @Test
    @DisplayName("사용자가 숫자가 아닌 다른 문자를 입력한 경우")
    void fail1() {
        assertThatThrownBy(() -> playerService.validate("1@3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("사용자가 3자리의 자연수를 입력하지 않은 경우")
    void fail2() {
        assertThatThrownBy(() -> playerService.validate("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("사용자가 입력한 숫자가 서로 다른 숫자가 아닌 경우")
    void fail3() {
        assertThatThrownBy(() -> playerService.validate("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}