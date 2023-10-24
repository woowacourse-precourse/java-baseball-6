package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerBallsTest {

    @Test
    void 생성_테스트() {
        Integer[] input = {1, 2, 3};
        PlayerBalls result = new PlayerBalls(input);
        List<Ball> expect = List.of(new Ball(1), new Ball(2), new Ball(3));
        assertEquals(expect, result.getBalls());
    }
}