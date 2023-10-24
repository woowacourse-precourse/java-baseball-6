package baseball.scene;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameOverCommandTest {
    @ParameterizedTest
    @MethodSource("provideGameOverCommand")
    void 게임_종료_메뉴에_해당하는_명령어로_find_메소드_호출시_GameOverCommand_반환(String command, GameOverCommand expected) {
        final GameOverCommand gameOverCommand = GameOverCommand.find(command);
        assertThat(gameOverCommand).isEqualTo(expected);
    }

    private static Stream<Arguments> provideGameOverCommand() {
        return Stream.of(
                Arguments.of(GameOverCommand.STRING_RE_START_INPUT, GameOverCommand.RE_START),
                Arguments.of(GameOverCommand.STRING_EXIT_INPUT, GameOverCommand.EXIT),
                Arguments.of("0", GameOverCommand.UNKNOWN)
        );
    }

    @Test
    void updateFromUserInput_메소드_재시작_메뉴_선택() {
        final GameStateManager mockGameStateManager = mock(GameStateManager.class);

        final String userInput = GameOverCommand.STRING_RE_START_INPUT;

        GameOverCommand.updateFromUserInput(mockGameStateManager, userInput);

        verify(mockGameStateManager, times(1)).update(GameState.GAME);
    }

    @Test
    void updateFromUserInput_메소드_게임_종료_메뉴_선택() {
        final GameStateManager mockGameStateManager = mock(GameStateManager.class);

        final String userInput = GameOverCommand.STRING_EXIT_INPUT;

        GameOverCommand.updateFromUserInput(mockGameStateManager, userInput);

        verify(mockGameStateManager, times(1)).update(GameState.EXIT);
    }

    @Test
    void updateFromUserInput_메소드_지원하지_않는_메뉴_입력시_IllegalArgumentException_예외() {
        final GameStateManager mockGameStateManager = mock(GameStateManager.class);

        final String userInput = GameOverCommand.STRING_UNKNOWN;

        assertThatThrownBy(() -> GameOverCommand.updateFromUserInput(mockGameStateManager, userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
