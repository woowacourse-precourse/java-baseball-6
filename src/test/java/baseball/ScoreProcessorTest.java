package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ScoreProcessorTest {
    private final ScoreProcessor scoreProcessor = new ScoreProcessor();

    @Test
    void 낫싱() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(7, 8, 9));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(0, strikeCount);
        assertEquals(0, ballCount);
        assertEquals("낫싱", score.getScoreResult());
        assertEquals(false, score.isThreeStrikes());
    }

    @Test
    void 테스트_원스트라이크() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(1, 4, 5));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(1, strikeCount);
        assertEquals(0, ballCount);
        assertEquals("1스트라이크", score.getScoreResult());
        assertEquals(false, score.isThreeStrikes());
    }

    @Test
    void 테스트_투스트라이크() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(1, 2, 5));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(2, strikeCount);
        assertEquals(0, ballCount);
        assertEquals("2스트라이크", score.getScoreResult());
        assertEquals(false, score.isThreeStrikes());
    }

    @Test
    void 테스트_쓰리스트라이크() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(1, 2, 3));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(3, strikeCount);
        assertEquals(0, ballCount);
        assertEquals("3스트라이크", score.getScoreResult());
        assertEquals(true, score.isThreeStrikes());
    }

    @Test
    void 테스트_원볼() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(8, 4, 2));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(0, strikeCount);
        assertEquals(1, ballCount);
        assertEquals("1볼", score.getScoreResult());
        assertEquals(false, score.isThreeStrikes());
    }

    @Test
    void 테스트_투볼() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(8, 1, 2));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(0, strikeCount);
        assertEquals(2, ballCount);
        assertEquals("2볼", score.getScoreResult());
        assertEquals(false, score.isThreeStrikes());
    }

    @Test
    void 테스트_쓰리볼() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(3, 1, 2));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(0, strikeCount);
        assertEquals(3, ballCount);
        assertEquals("3볼", score.getScoreResult());
        assertEquals(false, score.isThreeStrikes());
    }

    @Test
    void 테스트_원볼_원스트라이크() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(1, 8, 2));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(1, strikeCount);
        assertEquals(1, ballCount);
        assertEquals("1볼 1스트라이크", score.getScoreResult());
        assertEquals(false, score.isThreeStrikes());
    }

    @Test
    void 테스트_투볼_원스트라이크() {
        // given
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(List.of(1, 3, 2));

        Score score = scoreProcessor.processScore(computerNumbers, playerNumbers);

        // when
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        // then
        assertEquals(1, strikeCount);
        assertEquals(2, ballCount);
        assertEquals("2볼 1스트라이크", score.getScoreResult());
        assertEquals(false, score.isThreeStrikes());
    }
}