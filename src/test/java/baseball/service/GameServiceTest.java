package baseball.service;

import baseball.domain.Ball;
import baseball.domain.ComputerBalls;
import baseball.domain.PlayerBalls;
import baseball.domain.PlayerResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void 스트라이크_확인() {
        Integer[] playerNumbers = {1, 2, 3};
        PlayerBalls playerBalls = new PlayerBalls(playerNumbers);
        List<Ball> computerBalls = List.of(new Ball(1), new Ball(3), new Ball(2));
        GameService service = new GameService();
        PlayerResult result = service.judge(playerBalls.getBalls(), computerBalls);

        assertEquals(1, result.getStrike());
    }

    @Test
    void 볼_확인() {
        Integer[] playerNumbers = {1, 2, 3};
        PlayerBalls playerBalls = new PlayerBalls(playerNumbers);
        List<Ball> computerBalls = List.of(new Ball(1), new Ball(3), new Ball(2));
        GameService service = new GameService();
        PlayerResult result = service.judge(playerBalls.getBalls(), computerBalls);
        assertEquals(2, result.getBall());
    }

    @Test
    void 낫싱_확인() {
        Integer[] playerNumbers = {1, 2, 3};
        PlayerBalls playerBalls = new PlayerBalls(playerNumbers);
        List<Ball> computerBalls = List.of(new Ball(9), new Ball(8), new Ball(7));
        GameService service = new GameService();
        PlayerResult result = service.judge(playerBalls.getBalls(), computerBalls);

        assertEquals(0, result.getStrike());
        assertEquals(0, result.getBall());
    }
}