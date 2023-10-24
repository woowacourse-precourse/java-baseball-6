package baseball.game;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import baseball.scene.SceneFactory;
import baseball.scene.SceneManager;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

public class GameManagerTest {

    @Test
    void loop_메서드_초기화로_GameState_START_으로_초기화() {
        final GameStateManager mockGameStateManager = mock(GameStateManager.class);
        final SceneManager mockSceneManager = mock(SceneManager.class);
        final SceneFactory mockSceneFactory = mock(SceneFactory.class);

        when(mockGameStateManager.isInExit()).thenReturn(true);

        final GameManager gameManager = new GameManager(mockGameStateManager, mockSceneManager, mockSceneFactory);
        gameManager.loop();

        verify(mockGameStateManager, times(1)).update(GameState.START);
    }

    @Test
    void loop_메서드_EXIT_상태까지_Scene을_불러오고_실행() {
        final GameStateManager mockGameStateManager = mock(GameStateManager.class);
        final SceneManager mockSceneManager = mock(SceneManager.class);
        final SceneFactory mockSceneFactory = mock(SceneFactory.class);

        when(mockGameStateManager.isInExit()).thenReturn(false, true);
        when(mockSceneFactory.createSceneFromGameState()).thenReturn(() -> {});

        final GameManager gameManager = new GameManager(mockGameStateManager, mockSceneManager, mockSceneFactory);
        gameManager.loop();

        verify(mockSceneFactory, times(1)).createSceneFromGameState();
        verify(mockSceneManager, times(1)).load(ArgumentMatchers.any());
    }
}
