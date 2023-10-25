package baseball.service;

import baseball.model.Computer;
import baseball.model.GameRestartState;
import baseball.model.Player;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    private final Computer computer = new Computer();
    private final Player player = new Player();

    @Test
    void 컴퓨터_숫자_랜덤생성_테스트() {
        // when
        computer.generateRandomNumbers();

        // then
        assertEquals(3, computer.getNumbers().size());
    }

    @Test
    void 스트라이크_개수_테스트() {
        // given
        BaseballGame baseballGame = new BaseballGame(computer, player);
        List<Integer> computerNums = Lists.list(7, 1, 4);

        // when
        int res1 = baseballGame.countStrikes(computerNums, Lists.list(3, 1, 4));
        int res2 = baseballGame.countStrikes(computerNums, Lists.list(7, 1, 4));
        int res3 = baseballGame.countStrikes(computerNums, Lists.list(6, 3, 4));
        int res4 = baseballGame.countStrikes(computerNums, Lists.list(6, 3, 8));

        // then
        assertEquals(2, res1);
        assertEquals(3, res2);
        assertEquals(1, res3);
        assertEquals(0, res4);
    }

    @Test
    void 볼_개수_테스트() {
        // given
        BaseballGame baseballGame = new BaseballGame(computer, player);
        List<Integer> computerNums = Lists.list(7, 1, 4);

        // when
        int res1 = baseballGame.countBalls(computerNums, Lists.list(1, 2, 3));
        int res2 = baseballGame.countBalls(computerNums, Lists.list(4, 5, 6));
        int res3 = baseballGame.countBalls(computerNums, Lists.list(1, 4, 7));
        int res4 = baseballGame.countBalls(computerNums, Lists.list(9, 5, 3));

        // then
        assertEquals(1, res1);
        assertEquals(1, res2);
        assertEquals(3, res3);
        assertEquals(0, res4);
    }

    @Test
    void 플레이어_게임_재시작_요청_테스트() {
        // given
        String restartInput = "1";

        // when
        GameRestartState restartFlagByPlayer = GameRestartState.findGameStateFromString(restartInput);

        // then
        assertEquals(GameRestartState.RESTART, restartFlagByPlayer);
    }

    @Test
    void 플레이어_게임_종료_요청_테스트() {
        // given
        String restartInput = "2";

        // when
        GameRestartState restartFlagByPlayer = GameRestartState.findGameStateFromString(restartInput);

        // then
        assertEquals(GameRestartState.GAME_OVER, restartFlagByPlayer);
    }

    @Test
    void 플레이어_게임_재시작_비정상_값_테스트() {
        // given
        String restartInput = "1234";

        // when
        GameRestartState restartFlagByPlayer = GameRestartState.findGameStateFromString(restartInput);

        // then
        assertEquals(GameRestartState.UNKNOWN, restartFlagByPlayer);
    }

    @Test
    void 플레이어_승리조건_달성_성공_테스트() {
        // given
        computer.setNumbers(Lists.list(2, 3, 5));
        player.setNumbers(Lists.list(2, 3, 5));

        BaseballGame baseballGame = new BaseballGame(computer, player);

        // when
        boolean playerHit = baseballGame.isPlayerHit();

        // then
        assertTrue(playerHit);
    }

    @Test
    void 플레이어_승리_조건달성_실패_테스트() {
        // given
        computer.setNumbers(Lists.list(2, 3, 5));
        player.setNumbers(Lists.list(2, 7, 5));
        BaseballGame baseballGame = new BaseballGame(computer, player);

        // when
        boolean playerHit = baseballGame.isPlayerHit();

        // then
        assertFalse(playerHit);
    }
}