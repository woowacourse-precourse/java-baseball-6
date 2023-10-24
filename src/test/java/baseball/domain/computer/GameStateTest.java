package baseball.domain.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    @Test
    @DisplayName("존재하지 않는 command로 생성 시 exception이 발생해야 한다.")
    void createExceptionByNonExistCommand() {
        // given
        int input = 3;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> GameState.createByCommand(input))
                .withMessageMatching("존재하지 않는 게임 상태 입니다.");
    }
}