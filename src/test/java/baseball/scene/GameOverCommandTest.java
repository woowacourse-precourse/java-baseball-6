package baseball.scene;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.GameConstants;
import baseball.game.state.GameState;
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
}
