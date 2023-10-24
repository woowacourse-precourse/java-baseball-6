package baseball.game.state;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameStateManagerTest {

    @ParameterizedTest
    @MethodSource("provideGameStateAtIsInStart")
    void GameState_START_일때_isInStart_true_반환(final GameState gameState, final boolean expected) {
        final GameStateManager gameStateManager = new GameStateManager();
        gameStateManager.update(gameState);

        assertThat(gameStateManager.isInStart()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideGameStateAtIsInStart() {
        return Stream.of(
                Arguments.of(GameState.START, true),
                Arguments.of(GameState.GAME, false),
                Arguments.of(GameState.GAME_OVER, false),
                Arguments.of(GameState.EXIT, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGameStateAtIsInGame")
    void GameState_GAME_일때_isInGame_true_반환(GameState gameState, boolean expected) {
        GameStateManager gameStateManager = new GameStateManager();
        gameStateManager.update(gameState);

        assertThat(gameStateManager.isInGame()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideGameStateAtIsInGame() {
        return Stream.of(
                Arguments.of(GameState.START, false),
                Arguments.of(GameState.GAME, true),
                Arguments.of(GameState.GAME_OVER, false),
                Arguments.of(GameState.EXIT, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGameStateAtIsInGameOver")
    void GameState_GAME_일때_isInGameOver_true_반환(GameState gameState, boolean expected) {
        GameStateManager gameStateManager = new GameStateManager();
        gameStateManager.update(gameState);

        assertThat(gameStateManager.isInGameOver()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideGameStateAtIsInGameOver() {
        return Stream.of(
                Arguments.of(GameState.START, false),
                Arguments.of(GameState.GAME, false),
                Arguments.of(GameState.GAME_OVER, true),
                Arguments.of(GameState.EXIT, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGameStateAtIsInExit")
    void GameState_GAME_일때_isInExit_true_반환(GameState gameState, boolean expected) {
        GameStateManager gameStateManager = new GameStateManager();
        gameStateManager.update(gameState);

        assertThat(gameStateManager.isInExit()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideGameStateAtIsInExit() {
        return Stream.of(
                Arguments.of(GameState.START, false),
                Arguments.of(GameState.GAME, false),
                Arguments.of(GameState.GAME_OVER, false),
                Arguments.of(GameState.EXIT, true)
        );
    }

    @Test
    void update_메소드로_GAME_단계_수정_이전에_isInGame_호출시_false_반환() {
        GameStateManager gameStateManager = new GameStateManager();
        assertThat(gameStateManager.isInGame()).isFalse();
        gameStateManager.update(GameState.GAME);
    }

    @Test
    void update_메소드로_GAME_단계_수정_이후에_isInGame_호출시_true_반환() {
        GameStateManager gameStateManager = new GameStateManager();
        gameStateManager.update(GameState.GAME);
        assertThat(gameStateManager.isInGame()).isTrue();
    }
}
