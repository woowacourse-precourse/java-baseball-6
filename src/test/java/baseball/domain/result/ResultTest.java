package baseball.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    @DisplayName("Result는 조건이 맞으면 정상 생성 되어야 한다.")
    void Ball_정상_생성() {
        Result result = new Result(3,4);

        assertNotNull(result);
        assertEquals(3, result.strike());
        assertEquals(4, result.ball());
    }

    @Test
    @DisplayName("Result의 getStrike는 strike를 반환한다.")
    void GetStrike는_strike를_반환() {
        Result result = new Result(3,0);

        assertEquals(3, result.strike());
    }

    @Test
    @DisplayName("Result의 getBall은 ball을 반환한다.")
    void GetBall은_ball을_반환() {
        Result result = new Result(0,3);

        assertEquals(3, result.ball());
    }

    @Test
    @DisplayName("Result의 isComplete는 3스트라이크의 경우 True")
    void isComplete는_3스트라이크면_True() {
        Result result = new Result(3,0);

        assertTrue(result.isComplete());
    }

    @Test
    @DisplayName("Result의 isComplete는 3스트라이크의가 아니면 False")
    void isComplete는_3스트라이크면가_아니면_False() {
        Result result = new Result(2,1);

        assertFalse(result.isComplete());
    }
}