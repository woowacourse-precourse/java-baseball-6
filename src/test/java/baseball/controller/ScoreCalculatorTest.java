package baseball.controller;

import baseball.model.GameNumbers;
import baseball.model.Score;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Test
    void calculateScore_3스트라이크() {
        // given
        GameNumbers playerNumbers = new GameNumbers(List.of(1, 2, 3));
        GameNumbers answer = new GameNumbers(List.of(1, 2, 3));
        Score expected = new Score(0, 3);

        // when
        Score score = scoreCalculator.calculateScore(playerNumbers, answer);

        // then
        assertThat(score.toString()).isEqualTo(expected.toString());
        assertThat(score.isThreeStrike()).isEqualTo(true);
    }

    @Test
    void calculateScore_1볼_1스트라이크() {
        // given
        GameNumbers playerNumbers = new GameNumbers(List.of(1, 2, 3));
        GameNumbers answer = new GameNumbers(List.of(1, 3, 4));
        Score expected = new Score(1, 1);

        // when
        Score score = scoreCalculator.calculateScore(playerNumbers, answer);

        // then
        assertThat(score.toString()).isEqualTo(expected.toString());
        assertThat(score.isThreeStrike()).isEqualTo(false);
    }

    @Test
    void calculateScore_2볼() {
        // given
        GameNumbers playerNumbers = new GameNumbers(List.of(4, 1, 9));
        GameNumbers answer = new GameNumbers(List.of(1, 3, 4));
        Score expected = new Score(2, 0);

        // when
        Score score = scoreCalculator.calculateScore(playerNumbers, answer);

        // then
        assertThat(score.toString()).isEqualTo(expected.toString());
        assertThat(score.isThreeStrike()).isEqualTo(false);
    }

    @Test
    void calculateScore_나싱() {
        // given
        GameNumbers playerNumbers = new GameNumbers(List.of(7, 8, 9));
        GameNumbers answer = new GameNumbers(List.of(1, 3, 4));
        Score expected = new Score(0, 0);

        // when
        Score score = scoreCalculator.calculateScore(playerNumbers, answer);

        // then
        assertThat(score.toString()).isEqualTo(expected.toString());
        assertThat(score.isThreeStrike()).isEqualTo(false);
    }
}
