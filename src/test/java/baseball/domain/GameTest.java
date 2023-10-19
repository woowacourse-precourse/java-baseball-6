package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void 게임_시작_전() {
        Game game = new Game();
        assertEquals(game.getGameState(), GameState.READY);
    }
}
