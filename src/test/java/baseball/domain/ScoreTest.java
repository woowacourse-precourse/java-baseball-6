package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ScoreTest {
    @Test
    void 낫싱_아웃풋_테스트() {
        int strikeScore = 0, ballScore = 0;
        Score score = new Score(strikeScore, ballScore);
        assertThat(score.getScoreOutput().equals("낫싱"));
    }

    @Test
    void 스트라이크만_아웃풋_테스트() {
        int strikeScore = 1, ballScore = 0;
        Score score = new Score(strikeScore, ballScore);
        assertThat(score.getScoreOutput().equals("1스트라이크"));
    }

    @Test
    void 볼만_아웃풋_테스트() {
        int strikeScore = 0, ballScore = 2;
        Score score = new Score(strikeScore, ballScore);
        assertThat(score.getScoreOutput().equals("2볼"));
    }

    @Test
    void 스트라이크와_볼_아웃풋_테스트() {
        int strikeScore = 1, ballScore = 1;
        Score score = new Score(strikeScore, ballScore);
        assertThat(score.getScoreOutput().equals("1볼 1스트라이크"));
    }
}
