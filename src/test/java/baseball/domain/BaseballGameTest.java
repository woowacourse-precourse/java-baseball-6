package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @DisplayName("새로운 게임을 시작한다")
    @Test
    void newGame() {
        // TODO computerBalls가 제대로 생성되었는지 어떻게 검증할까?
        BaseballGame baseballGame = BaseballGame.newGame(() -> "123");
    }

}
