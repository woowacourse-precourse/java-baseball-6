package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameManagerTest {

    private GameManager gameManager = new GameManager();

    @Test
    @DisplayName("게임 종료 후 , 재시작 또는 종료 외의 다른 입력시, 예외처리")
    public void GameManagerTest() {
        assertThatThrownBy(()->gameManager.validateRestartOrExitWrongInput("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}