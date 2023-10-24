package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import baseball.controller.GameState.State;
import org.junit.jupiter.api.Test;


class GameControllerTest {

    GameControllerImpl gameController = new GameControllerImpl();

    @Test
    public void 게임시작_플레이_상태로_변하고_채점_준비한다() {
        gameController.start();

        assertEquals(gameController.getGameState().getState(), State.PLAYING);
        assertNotNull(gameController.getScoring());
    }

}