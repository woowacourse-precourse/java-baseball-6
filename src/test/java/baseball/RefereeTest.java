package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RefereeTest {
    @ParameterizedTest
    @CsvSource({
            "135, 124, 1",
            "135, 134, 2",
            "135, 135, 3"
    })
    void 스트라이크_개수_판단(String computerNumbers, String playerNumbers, int expectedStrikeCount) {
        Referee referee = new Referee();
        int actualStrikeCount = referee.getStrikeCount(computerNumbers, playerNumbers);
        assertEquals(expectedStrikeCount, actualStrikeCount);
    }

    @ParameterizedTest
    @CsvSource({
            "135, 214, 1",
            "135, 314, 2",
            "135, 351, 3"
    })
    void 볼_개수_판단(String computerNumbers, String playerNumbers, int expectedBallCount) {
        Referee referee = new Referee();
        int actualBallCount = referee.getBallCount(computerNumbers, playerNumbers);
        assertEquals(expectedBallCount, actualBallCount);
    }
}