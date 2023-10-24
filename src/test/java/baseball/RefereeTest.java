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
}