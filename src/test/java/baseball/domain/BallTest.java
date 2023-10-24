package baseball.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    List<Ball> computerBalls = new ArrayList<>();

    @BeforeEach
    public void init() {
        Ball ball1 = new Ball(0, 1);
        Ball ball2 = new Ball(1, 2);
        Ball ball3 = new Ball(2, 3);
        computerBalls.add(ball1);
        computerBalls.add(ball2);
        computerBalls.add(ball3);
    }

    @Test
    @DisplayName("숫자야구 판정이 스트라이크인 경우")
    void matchReturnStrike() {
        Ball userBall = new Ball(1, 2);
        assertEquals(userBall.match(computerBalls), MatchResult.STRIKE);
    }

    @Test
    @DisplayName("숫자야구 판정이 볼인 경우")
    void matchReturnBall() {
        Ball userBall = new Ball(2, 2);
        assertEquals(userBall.match(computerBalls), MatchResult.BALL);
    }

    @Test
    @DisplayName("숫자야구 판정이 낫싱인 경우")
    void matchReturnNoting() {
        Ball userBall = new Ball(1, 9);
        assertEquals(userBall.match(computerBalls), MatchResult.NOTHING);
    }
}