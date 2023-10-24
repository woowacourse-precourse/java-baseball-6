package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import baseball.controller.GameState.State;
import org.junit.jupiter.api.Test;


class GameControllerTest {

    GameControllerImpl gameController = new GameControllerImpl(new Scoring(123));

    @Test
    public void 게임시작_플레이_상태로_변하고_채점_준비한다() {
        gameController.start();

        assertEquals(gameController.getGameState().getState(), State.PLAYING);
        assertNotNull(gameController.getScoring());
    }

    @Test
    public void 정답을_맞췄다면_게임이_종료된다() {
        gameController.start();
        gameController.checkAnswer("123");
        assertEquals(gameController.getGameState().getState(), State.TERMINATED);
    }

    @Test
    public void 정답을_못맞췄다면_게임이_계속진행된다() {
        gameController.start();
        gameController.checkAnswer("321");
        assertEquals(gameController.getGameState().getState(), State.PLAYING);
    }

}