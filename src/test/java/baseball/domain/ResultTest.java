package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("3스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenThreeStrike() {
        // given, when
        GameResult result = new GameResult(0, 3, 0);

        // then
        assertThat(result.toString()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("2스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenTwoStrike() {
        // given, when
        GameResult result = new GameResult(0, 2, 1);

        // then
        assertThat(result.toString()).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("1스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenOneStrike() {
        // given, when
        GameResult result = new GameResult(0, 1, 2);

        // then
        assertThat(result.toString()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("1볼 1스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenOneBallOneStrike() {
        // given, when
        GameResult result = new GameResult(1, 1, 1);

        // then
        assertThat(result.toString()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("2볼 1스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenTwoBallOneStrike() {
        // given, when
        GameResult result = new GameResult(2, 1, 0);

        // then
        assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("3볼 0스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenThreeBallZeroStrike() {
        // given, when
        GameResult result = new GameResult(3, 0, 0);

        // then
        assertThat(result.toString()).isEqualTo("3볼");
    }

    @Test
    @DisplayName("2볼 0스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenTwoBallZeroStrike() {
        // given, when
        GameResult result = new GameResult(2, 0, 1);

        // then
        assertThat(result.toString()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("1볼 0스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenOneBallZeroStrike() {
        // given, when
        GameResult result = new GameResult(1, 0, 2);

        // then
        assertThat(result.toString()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("0볼 0스트라이크 일 때, Result를 문자열로 잘 변환한다.")
    void testToStringWhenZeroBallZeroStrike() {
        // given, when
        GameResult result = new GameResult(0, 0, 3);

        // then
        assertThat(result.toString()).isEqualTo("낫싱");
    }

}