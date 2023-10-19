package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @DisplayName("스트라이크 개수가 제대로 저장됐는지 확인")
    @Test
    void StrikesIsCorrectlySaved() {
        Result result = new Result(3,0);

        assertEquals(result.numberOfStrikes, 3);
    }

    @DisplayName("볼 개수가 제대로 저장됐는지 확인")
    @Test
    void BallsISCorrectlySaved() {
        Result result = new Result(0, 3);

        assertEquals(result.numberOfBalls, 3);
    }
}
