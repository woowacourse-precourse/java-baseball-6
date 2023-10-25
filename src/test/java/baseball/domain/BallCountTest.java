package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.constant.ResultStatus;
import baseball.constant.StrikeBall;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("볼카운트 결과 도메인 클래스의 객체에")
class BallCountTest {

    @Test
    @DisplayName("스트라이크 개수 요청시 정상 값을 반환하는가")
    void getStrikeNum() {
        // given
        final BallCount ballCount =
                new BallCount(List.of(StrikeBall.STRIKE, StrikeBall.STRIKE, StrikeBall.NONE));

        // when
        final long strikeNum = ballCount.countStrike();

        // then
        assertThat(strikeNum).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 개수 요청시 정상 값을 반환하는가")
    void getBallNum() {
        // given
        final BallCount ballCount =
                new BallCount(List.of(StrikeBall.STRIKE, StrikeBall.BALL, StrikeBall.NONE));

        // when
        final long strikeNum = ballCount.countStrike();

        // then
        assertThat(strikeNum).isOne();
    }

    @Nested
    @DisplayName("결과 상태 요청시")
    class CheckResultStatus {

        @Test
        @DisplayName("3스트라이크인 경우 SUCCESS를 반환하는가")
        void threeStrikeToSuccess() {
            // given
            final BallCount ballCount =
                    new BallCount(List.of(StrikeBall.STRIKE, StrikeBall.STRIKE, StrikeBall.STRIKE));

            // when
            final ResultStatus result = ballCount.checkResultStatus();

            // then
            assertThat(result).isEqualTo(ResultStatus.SUCCESS);
        }

        @Test
        @DisplayName("3스트라이크가 아닌 경우 CONTINUE를 반환하는가")
        void twoStrikeToContinue() {
            // given
            final BallCount ballCount =
                    new BallCount(List.of(StrikeBall.STRIKE, StrikeBall.STRIKE, StrikeBall.NONE));

            // when
            final ResultStatus result = ballCount.checkResultStatus();

            // then
            assertThat(result).isEqualTo(ResultStatus.CONTINUE);
        }
    }

    @Nested
    @DisplayName("생성시")
    class CreateValidation {

        @Test
        @DisplayName("리스트 원소 개수가 3개 보다 적은 경우 예외를 던진다")
        void lessThanThreeElement() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new BallCount(List.of(StrikeBall.STRIKE)))
                    .isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("리스트 원소 개수가 3개 보다 많은 경우 예외를 던진다")
        void greaterThanThreeElement() {
            // given
            // when
            // then
            assertThatThrownBy(
                            () ->
                                    new BallCount(
                                            List.of(
                                                    StrikeBall.STRIKE,
                                                    StrikeBall.STRIKE,
                                                    StrikeBall.STRIKE,
                                                    StrikeBall.STRIKE)))
                    .isInstanceOf(IllegalStateException.class);
        }
    }
}
