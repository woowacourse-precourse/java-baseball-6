package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameResultTest {
    @ParameterizedTest
    @CsvSource({
            "135, 246, '낫싱\n'",
            "135, 154, '1볼 1스트라이크\n'",
            "135, 153, '2볼 1스트라이크\n'",
            "135, 135, '3스트라이크\n'"
    })
    void 게임_결과_출력(String computerNumbers, String playerNumbers, String expectedResult) {
        Referee referee = new Referee();
        int strikeCount = referee.getStrikeCount(computerNumbers, playerNumbers);
        int ballCount = referee.getBallCount(computerNumbers, playerNumbers);

        GameResult gameResult = new GameResult(ballCount, strikeCount);
        String actualResult = gameResult.result();
        assertEquals(expectedResult, actualResult);
    }
}
