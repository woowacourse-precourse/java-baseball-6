package baseball.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class GameStatusTest {

    @DisplayName("재시작에 해당하는 수를 입력 시 게임을 다시 시작할 수 있다")
    @Test
    void restart(){
        Integer retryNumber = 1;
        GameStatus expected = GameStatus.find(retryNumber);
        assertThat(GameStatus.RESTART).isEqualTo(expected);
    }



}