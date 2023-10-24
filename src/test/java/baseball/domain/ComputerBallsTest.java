package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerBallsTest {

    @Test
    void 생성된_볼_개수_테스트() {
        ComputerBalls computerBall = new ComputerBalls();
        List<Ball> result = computerBall.getBalls();

        assertEquals(3, result.size());
    }
}