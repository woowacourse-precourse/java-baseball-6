package baseball.scene;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import baseball.input.GameOverSceneInput;
import baseball.output.GameOverSceneOutput;
import org.junit.jupiter.api.Test;

public class GameOverSceneTest {

    @Test
    void 게임_종료_메시지_출력_호출_확인() {
        final GameStateManager mockGameStateManager = mock(GameStateManager.class);
        when(mockGameStateManager.isInGameOver()).thenReturn(true, false);

        final GameOverSceneInput mockInput = mock(GameOverSceneInput.class);
        when(mockInput.getUserInput()).thenReturn("1");

        final GameOverSceneOutput mockOutput = mock(GameOverSceneOutput.class);
        final GameOverScene gameOverScene = new GameOverScene(mockGameStateManager, mockInput, mockOutput);
        gameOverScene.run();

        verify(mockOutput, times(1)).printEndMessage();
    }
}
