package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    public void given() {
        gameManager = new GameManager();
    }

    @Test
    @DisplayName("게임 시작 시 초기화 값 true")
    public void testInitialGameStatus(){
        //then
        Assertions.assertTrue(gameManager.isNewGame());
    }
}
