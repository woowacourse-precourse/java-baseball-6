package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.state.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameStateTest {

    @Test
    public void 종료된상태라면_플레이상태로_변경할수있다() {
        GameState gameState = new GameState(GameState.getTerminatedState());
        gameState.changeStateToStartGame();

        assertTrue(gameState.isPlaying());
    }

    @Test
    public void 이미_플레이중이라면_플레이상태로_변경할수없다() {
        IllegalStateException i = Assertions.assertThrows(IllegalStateException.class, () -> {
            GameState gameState = new GameState(GameState.getPlayingState());
            gameState.changeStateToStartGame();
        });

        assertThat(i.getMessage().contains("게임을 시작할 수 없는 상태입니다."));
    }

    @Test
    public void 플레이상태라면_종료상태로_변경할수있다() {
        GameState gameState = new GameState(GameState.getPlayingState());
        gameState.changeStateToTerminateGame();

        assertTrue(gameState.isTerminated());
    }

    @Test
    public void 이미_종료상태라면_종료상태로_변경할수없다() {
        IllegalStateException i = Assertions.assertThrows(IllegalStateException.class, () -> {
            GameState gameState = new GameState(GameState.getTerminatedState());
            gameState.changeStateToTerminateGame();
        });

        assertThat(i.getMessage().contains("게임을 시작할 수 없는 상태입니다."));
    }

}