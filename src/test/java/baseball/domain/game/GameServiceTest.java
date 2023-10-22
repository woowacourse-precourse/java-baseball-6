package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    @Test
    @DisplayName("동일한 싱글톤 인스턴스를 반환합니다.")
    void getInstance() {
        // GIVEN
        GameService instance1 = GameService.getInstance(new User(), new Computer());

        // WHEN
        GameService instance2 = GameService.getInstance(new User(), new Computer());

        // THEN
        assertThat(instance1).isEqualTo(instance2);
    }
}