package baseball.domain.score;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.BaseballGame;
import org.junit.jupiter.api.Test;

public class ImmutableBallStrikeCountTest {

    private static final int ZERO_COUNT = 0;
    private static final String NOTHING = "낫싱\n";
    private static final String BALL_FORMAT = "%d볼\n";
    private static final String STRIKE_FORMAT = "%d스트라이크\n";
    private static final String BALL_AND_STRIKE_FORMAT = "%d볼 %d스트라이크\n";

    @Test
    void 전체_스트라이크일_경우_isAllStrike_참() {
        // Given
        ImmutableBallStrikeCount immutableBallStrikeCount = ImmutableBallStrikeCount.of(ZERO_COUNT,
                BaseballGame.BALL_COUNT);

        // When
        boolean actualResult = immutableBallStrikeCount.isAllStrike();

        // Then
        assertTrue(actualResult);
    }

    @Test
    void 전체_스트라이크가_아닐_경우_isAllStrike_거짓() {
        // Given
        ImmutableBallStrikeCount immutableBallStrikeCount = ImmutableBallStrikeCount.of(ZERO_COUNT, ZERO_COUNT);

        // When
        boolean actualResult = immutableBallStrikeCount.isAllStrike();

        // Then
        assertFalse(actualResult);
    }

    @Test
    void 값이_모두_0일_경우_낫싱_문자열_생성() {
        // When
        String actualResult = getBallStrikeCountFormattedResult(ZERO_COUNT, ZERO_COUNT);

        // Then
        assertEquals(NOTHING, actualResult);
    }

    @Test
    void 값이_모두_있는_경우_결과_올바르게_생성() {
        // Given
        int ballCount = getRandomNaturalNumber(2);
        int strikeCount = BaseballGame.BALL_COUNT - ballCount;
        String expectedResult = String.format(BALL_AND_STRIKE_FORMAT, ballCount, strikeCount);

        // When
        String actualResult = getBallStrikeCountFormattedResult(ballCount, strikeCount);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void 볼만_있는_경우_결과_올바르게_생성() {
        // Given
        int ballCount = getRandomNaturalNumber(3);
        String expectedResult = String.format(BALL_FORMAT, ballCount);

        // When
        String actualResult = getBallStrikeCountFormattedResult(ballCount, ZERO_COUNT);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void 스트라이크만_있는_경우_결과_올바르게_생성() {
        // Given
        int strikeCount = getRandomNaturalNumber(3);
        String expectedResult = String.format(STRIKE_FORMAT, strikeCount);

        // When
        String actualResult = getBallStrikeCountFormattedResult(ZERO_COUNT, strikeCount);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    private String getBallStrikeCountFormattedResult(int ballCount, int strikeCount) {
        ImmutableBallStrikeCount immutableBallStrikeCount = ImmutableBallStrikeCount.of(ballCount, strikeCount);

        return immutableBallStrikeCount.toFormattedResult();
    }

    private int getRandomNaturalNumber(int maxValue) {
        return (int) (Math.random() * maxValue) + 1;
    }
}
