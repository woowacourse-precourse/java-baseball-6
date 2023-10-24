package baseball.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBallTest {

    List<NumberBall> computerNumberBalls = new ArrayList<>();

    @BeforeEach
    public void init() {
        NumberBall numberBall1 = new NumberBall(0, 1);
        NumberBall numberBall2 = new NumberBall(1, 2);
        NumberBall numberBall3 = new NumberBall(2, 3);
        computerNumberBalls.add(numberBall1);
        computerNumberBalls.add(numberBall2);
        computerNumberBalls.add(numberBall3);
    }

    @Test
    @DisplayName("숫자야구 판정이 스트라이크인 경우")
    void matchReturnStrike() {
        NumberBall userNumberBall = new NumberBall(1, 2);
        assertEquals(userNumberBall.match(computerNumberBalls), MatchResult.STRIKE);
    }

    @Test
    @DisplayName("숫자야구 판정이 볼인 경우")
    void matchReturnBall() {
        NumberBall userNumberBall = new NumberBall(2, 2);
        assertEquals(userNumberBall.match(computerNumberBalls), MatchResult.BALL);
    }

    @Test
    @DisplayName("숫자야구 판정이 낫싱인 경우")
    void matchReturnNoting() {
        NumberBall userNumberBall = new NumberBall(1, 9);
        assertEquals(userNumberBall.match(computerNumberBalls), MatchResult.NOTHING);
    }
}