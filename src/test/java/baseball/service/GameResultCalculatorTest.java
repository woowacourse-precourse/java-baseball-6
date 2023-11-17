package baseball.service;

import baseball.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.service.GameResultCalculator.caculateGameResult;
import static baseball.service.GameResultCalculator.calculateStrikeCount;
import static org.assertj.core.api.Assertions.assertThat;

class GameResultCalculatorTest {
    @Test
    @DisplayName("3스트라이크 일 때, 스트라이크 개수를 정확하게 계산한다.")
    void calculateStrikeCountCorrectlyWhenThreeStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 2, 3);

        // when
        int result = calculateStrikeCount(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("2스트라이크 일 때, 스트라이크 개수를 정확하게 계산한다.")
    void calculateStrikeCountCorrectlyWhenTwoStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 2, 4);

        // when
        int result = calculateStrikeCount(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("1스트라이크 일 때, 스트라이크 개수를 정확하게 계산한다.")
    void calculateStrikeCountCorrectlyWhenOneStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 3, 2);

        // when
        int result = calculateStrikeCount(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("0스트라이크 일 때, 스트라이크 개수를 정확하게 계산한다.")
    void calculateStrikeCountCorrectlyWhenZeroStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(2, 3, 1);

        // when
        int result = calculateStrikeCount(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(0);
    }


    @Test
    @DisplayName("0볼 3스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenZeroBallThreeStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 2, 3);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(0, 3, 0));
    }

    @Test
    @DisplayName("0볼 2스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenZeroBallTwoStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 2, 4);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(0, 2, 1));
    }

    @Test
    @DisplayName("0볼 1스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenZeroBallOneStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 4, 5);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(0, 1, 2));
    }

    @Test
    @DisplayName("1볼 1스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenOneBallOneStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 3, 4);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(1, 1, 1));
    }

    @Test
    @DisplayName("2볼 1스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenTwoBallOneStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 3, 2);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(2, 1, 0));
    }

    @Test
    @DisplayName("1볼 0스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenOneBallZeroStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(2, 4, 5);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(1, 0, 2));
    }

    @Test
    @DisplayName("2볼 0스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenTwoBallZeroStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(2, 1, 4);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(2, 0, 1));
    }

    @Test
    @DisplayName("3볼 0스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenThreeBallZeroStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(2, 3, 1);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(3, 0, 0));
    }

    @Test
    @DisplayName("0볼 0스트라이크 일 때, Result를 정확하게 생성한다.")
    void calculateResultCorrectlyWhenZeroBallZeroStrike() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(4, 5, 6);

        // when
        GameResult result = caculateGameResult(computerNumbers, userNumbers);

        // then
        assertThat(result).isEqualTo(new GameResult(0, 0, 3));
    }
}