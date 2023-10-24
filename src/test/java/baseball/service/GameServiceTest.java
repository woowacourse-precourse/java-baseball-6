package baseball.service;

import baseball.domain.Ball;
import baseball.domain.ComputerBalls;
import baseball.domain.GameResult;
import baseball.domain.PlayerBalls;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void 스트라이크_판단_테스트() {
        Integer[] playerNumbers = {1, 2, 3};
        PlayerBalls playerBalls = new PlayerBalls(playerNumbers);
        List<Ball> computerBalls = List.of(new Ball(1), new Ball(3), new Ball(2));
        GameService service = new GameService();
        GameResult result = service.judge(playerBalls.getBalls(), computerBalls);

        assertEquals(1, result.getStrike());
    }


}