package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameManagerTest {
    private GameManager gameManager;
    private GameManager spyGameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();

    }

    @Test
    @DisplayName("isGameActive() 테스트")
    void testIsGameActive() {
        assertTrue(gameManager.isGameActive());
    }


}
