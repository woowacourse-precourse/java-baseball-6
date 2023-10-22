package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("스트라이크 개수가 제대로 저장됐는지 확인")
    @Test
    void StrikesIsCorrectlySaved() {
        Result result = new Result(new Strikes(3), new Balls(0));

        assertEquals(result.numberOfStrikes.getValue(), 3);
    }

    @DisplayName("볼 개수가 제대로 저장됐는지 확인")
    @Test
    void BallsISCorrectlySaved() {
        Result result = new Result(new Strikes(0), new Balls(3));

        assertEquals(result.numberOfBalls.getValue(), 3);
    }
}
