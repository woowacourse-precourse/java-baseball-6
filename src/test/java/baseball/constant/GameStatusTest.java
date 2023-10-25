package baseball.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStatusTest {

    @DisplayName("재시작에 해당하는 수를 입력 시 게임을 다시 시작할 수 있다")
    @Test
    void restart() {
        Integer retryNumber = 1;
        GameStatus result = GameStatus.apply(retryNumber);
        assertThat(result).isEqualTo(GameStatus.RESTART);
    }

    @DisplayName("종료에 해당하는 수를 입력 시 게임을 종료할 수 있다")
    @Test
    void quit() {
        Integer quitNumber = 2;
        GameStatus result = GameStatus.apply(quitNumber);
        assertThat(result).isEqualTo(GameStatus.QUIT);
    }

    @DisplayName("종료/재시작에 해당하지 않는 수를 입력 시 예외를 던진다")
    @Test
    void exception() {
        Integer inValidNumber = 3;
        assertThrows(IllegalArgumentException.class, () -> GameStatus.apply(inValidNumber));
    }


}