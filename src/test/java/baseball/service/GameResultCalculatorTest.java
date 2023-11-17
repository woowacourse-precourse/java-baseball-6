package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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




}