package baseball.scene;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import baseball.input.GameSceneInput;
import baseball.output.GameSceneOutput;
import baseball.util.RandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class GameSceneTest {

    @Test
    void 컴퓨터가_랜덤으로_숫자_생성하는_메소드_호출_확인() {
        try (final MockedStatic<RandomNumberGenerator> mockGenerator = mockStatic(RandomNumberGenerator.class)) {
            mockGenerator.when(() -> RandomNumberGenerator.generate()).thenReturn(List.of(1, 2, 3));

            final GameStateManager mockGameStateManager = mock(GameStateManager.class);
            when(mockGameStateManager.isInGame()).thenReturn(true, false);

            final GameSceneInput mockInput = mock(GameSceneInput.class);
            when(mockInput.getUserInput()).thenReturn("123");

            final GameSceneOutput output = new GameSceneOutput();
            final GameScene gameScene = new GameScene(mockGameStateManager, mockInput, output);
            gameScene.run();

            mockGenerator.verify(() -> RandomNumberGenerator.generate(), times(1));
        }
    }

    @Test
    void 숫자_입력_메시지를_출력하는_메소드_호출_확인() {
        try (final MockedStatic<RandomNumberGenerator> mockGenerator = mockStatic(RandomNumberGenerator.class)) {
            mockGenerator.when(() -> RandomNumberGenerator.generate()).thenReturn(List.of(1, 2, 3));

            final GameStateManager mockGameStateManager = mock(GameStateManager.class);
            when(mockGameStateManager.isInGame()).thenReturn(true, false);

            final GameSceneInput mockInput = mock(GameSceneInput.class);
            when(mockInput.getUserInput()).thenReturn("123");

            final GameSceneOutput mockOutput = mock(GameSceneOutput.class);
            final GameScene gameScene = new GameScene(mockGameStateManager, mockInput, mockOutput);
            gameScene.run();

            verify(mockOutput, times(1)).printInputMessage();
        }
    }

    @Test
    void 숫자_입력하는_메소드_호출_확인() {
        try (final MockedStatic<RandomNumberGenerator> mockGenerator = mockStatic(RandomNumberGenerator.class)) {
            mockGenerator.when(() -> RandomNumberGenerator.generate()).thenReturn(List.of(1, 2, 3));

            final GameStateManager mockGameStateManager = mock(GameStateManager.class);
            when(mockGameStateManager.isInGame()).thenReturn(true, false);

            final GameSceneInput mockInput = mock(GameSceneInput.class);
            when(mockInput.getUserInput()).thenReturn("123");

            final GameSceneOutput mockOutput = mock(GameSceneOutput.class);
            final GameScene gameScene = new GameScene(mockGameStateManager, mockInput, mockOutput);
            gameScene.run();

            verify(mockInput, times(1)).getUserInput();
        }
    }

    @Test
    void 정답이_아닐시_재_입력_확인() {
        try (final MockedStatic<RandomNumberGenerator> mockGenerator = mockStatic(RandomNumberGenerator.class)) {
            mockGenerator.when(() -> RandomNumberGenerator.generate()).thenReturn(List.of(1, 2, 3));

            final GameStateManager mockGameStateManager = mock(GameStateManager.class);
            when(mockGameStateManager.isInGame()).thenReturn(true, true, false);

            final GameSceneInput mockInput = mock(GameSceneInput.class);
            when(mockInput.getUserInput()).thenReturn("124", "123");

            final GameSceneOutput mockOutput = mock(GameSceneOutput.class);
            final GameScene gameScene = new GameScene(mockGameStateManager, mockInput, mockOutput);
            gameScene.run();

            verify(mockInput, times(2)).getUserInput();
        }
    }

    @Test
    void 모두_스트라이크로_정답을_맞출시_GAME_OVER_상태로_변경() {
        try (final MockedStatic<RandomNumberGenerator> mockGenerator = mockStatic(RandomNumberGenerator.class)) {
            mockGenerator.when(() -> RandomNumberGenerator.generate()).thenReturn(List.of(1, 2, 3));

            final GameStateManager mockGameStateManager = mock(GameStateManager.class);
            when(mockGameStateManager.isInGame()).thenReturn(true, false);

            final GameSceneInput mockInput = mock(GameSceneInput.class);
            when(mockInput.getUserInput()).thenReturn("123");

            final GameSceneOutput mockOutput = mock(GameSceneOutput.class);
            final GameScene gameScene = new GameScene(mockGameStateManager, mockInput, mockOutput);
            gameScene.run();

            verify(mockGameStateManager, times(1)).update(GameState.GAME_OVER);
        }
    }
}
