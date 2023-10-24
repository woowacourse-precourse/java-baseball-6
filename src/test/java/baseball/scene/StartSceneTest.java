package baseball.scene;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import baseball.output.StartSceneOutput;
import org.junit.jupiter.api.Test;

public class StartSceneTest {

    @Test
    void 게임_시작_메시지_출력() {
        final StartSceneOutput mockBaseBallOutput = mock(StartSceneOutput.class);

        final GameStateManager gameStateManager = new GameStateManager();
        final StartScene startScene = new StartScene(gameStateManager, mockBaseBallOutput);
        startScene.run();

        verify(mockBaseBallOutput, times(1)).printStartMessage();
    }

    @Test
    void GAME_상태로_업데이트() {
        final GameStateManager mockGameStateManager = mock(GameStateManager.class);
        final StartSceneOutput startSceneOutput = new StartSceneOutput();

        final StartScene startScene = new StartScene(mockGameStateManager, startSceneOutput);
        startScene.run();

        verify(mockGameStateManager, times(1)).update(GameState.GAME);
    }
}
