package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameManagerTest {
    @InjectMocks
    private GameManager gameManager;

    @Mock
    private UserInterface userInterface;

    @Mock
    private ExceptionHandler exceptionHandler;

    @Mock
    private Computer computer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gameManager = new GameManager();
    }

    @Test
    @DisplayName("게임 시작 시 초기화 값 true")
    public void testInitialGameStatus() {
        //then
        assertTrue(gameManager.isNewGame());
    }


}
