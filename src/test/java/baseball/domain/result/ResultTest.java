package baseball.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    @DisplayName("Result는 조건이 맞으면 정상 생성 되어야 한다.")
    void Ball_정상_생성() {
        Result result = new Result();

        assertNotNull(result);
        assertEquals(0, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    @DisplayName("Result의 increaseStrike는 strike를 1 증가시킨다.")
    void IncreaseStrike는_strike_1증가() {
        Result result = new Result();
        result.increaseStrike();

        assertEquals(1, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    @DisplayName("Result의 increaseBall은 ball을 1 증가시킨다.")
    void IncreaseBall은_ball1증가() {
        Result result = new Result();
        result.increaseBall();

        assertEquals(0, result.getStrike());
        assertEquals(1, result.getBall());
    }

    @Test
    @DisplayName("Result의 increase 동시 실행하면 1스트라이크 1볼이 증가된다.")
    void Increase를_같이하면_1씩_증가() {
        Result result = new Result();
        result.increaseStrike();
        result.increaseBall();

        assertEquals(1, result.getStrike());
        assertEquals(1, result.getBall());
    }

    @Test
    @DisplayName("Result의 getStrike는 strike를 반환한다.")
    void GetStrike는_strike를_반환() {
        Result result = new Result();
        result.increaseStrike();
        result.increaseStrike();
        result.increaseStrike();

        assertEquals(3, result.getStrike());
    }

    @Test
    @DisplayName("Result의 getBall은 ball을 반환한다.")
    void GetBall은_ball을_반환() {
        Result result = new Result();
        result.increaseBall();
        result.increaseBall();
        result.increaseBall();

        assertEquals(3, result.getBall());
    }
}