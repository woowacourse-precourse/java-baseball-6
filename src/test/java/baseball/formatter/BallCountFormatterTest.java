package baseball.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.BallCountMessage;
import baseball.constant.StrikeBall;
import baseball.domain.BallCount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("볼카운트 메시지 포맷팅 클래스의 객체에")
class BallCountFormatterTest {

    private final BallCountFormatter ballCountFormatter = new BallCountFormatter();

    @Nested
    @DisplayName("포맷팅 요청시")
    class Format {

        @Test
        @DisplayName("모두 틀렸을때 메시지 포맷팅이 수행되는가")
        void none() {
            // given
            final BallCount ballCount =
                    new BallCount(List.of(StrikeBall.NONE, StrikeBall.NONE, StrikeBall.NONE));

            // when
            final String formatted = ballCountFormatter.format(ballCount);

            // then
            assertThat(formatted).isEqualTo(BallCountMessage.NOTHING.toValue());
        }

        @Test
        @DisplayName("스트라이크만 존재할 때 메시지 포맷팅이 수행되는가")
        void onlyStrike() {
            // given
            final BallCount ballCount =
                    new BallCount(List.of(StrikeBall.STRIKE, StrikeBall.STRIKE, StrikeBall.NONE));

            // when
            final String formatted = ballCountFormatter.format(ballCount);

            // then
            assertThat(formatted)
                    .contains(
                            String.format(
                                    BallCountMessage.STRIKE.toValue(), ballCount.countStrike()));
        }

        @Test
        @DisplayName("볼만 존재할 때 메시지 포맷팅이 수행되는가")
        void onlyBall() {
            // given
            final BallCount ballCount =
                    new BallCount(List.of(StrikeBall.BALL, StrikeBall.NONE, StrikeBall.NONE));

            // when
            final String formatted = ballCountFormatter.format(ballCount);

            // then
            assertThat(formatted)
                    .contains(
                            String.format(BallCountMessage.BALL.toValue(), ballCount.countBall()));
        }

        @Test
        @DisplayName("스트라이크 볼 모두 존재할 때 메시지 포맷팅이 수행되는가")
        void strikeAndBall() {
            // given
            final BallCount ballCount =
                    new BallCount(List.of(StrikeBall.STRIKE, StrikeBall.BALL, StrikeBall.STRIKE));

            // when
            final String formatted = ballCountFormatter.format(ballCount);

            // then
            assertThat(formatted)
                    .contains(
                            String.format(
                                    BallCountMessage.STRIKE.toValue(), ballCount.countStrike()),
                            String.format(BallCountMessage.BALL.toValue(), ballCount.countBall()));
        }
    }
}
