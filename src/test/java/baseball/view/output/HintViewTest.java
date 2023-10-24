package baseball.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.game.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class HintViewTest {

    @DisplayName("ball, strike가 0이면 HintView.NOTHING을 렌더링한다.")
    @Test
    void renderNothingIfBallAndStrikeCountZero() {
        // given
        final GameResult result = new GameResult(0, 0);
        final HintView view = new HintView(result);

        // when
        final String renderedString = view.renderToString();

        // then
        assertThat(renderedString).contains(HintView.NOTHING);
    }

    @DisplayName("ball이 3, strike가 0이면 HintView.BALL만 렌더링한다.")
    @Test
    void renderBallCount() {
        // given
        final int ballCount = 3;
        final int strikeCount = 0;
        final GameResult result = new GameResult(ballCount, strikeCount);
        final HintView view = new HintView(result);

        // when
        final String renderedString = view.renderToString();

        // then
        assertThat(renderedString)
                .contains(HintView.BALL)
                .doesNotContain(HintView.STRIKE);
    }

    @DisplayName("ball이 0, strike가 3이면 HintView.STRIKE만 렌더링한다.")
    @Test
    void renderStrikeCount() {
        // given
        final int ballCount = 0;
        final int strikeCount = 3;
        final GameResult result = new GameResult(ballCount, strikeCount);
        final HintView view = new HintView(result);

        // when
        final String renderedString = view.renderToString();

        // then
        assertThat(renderedString)
                .doesNotContain(HintView.BALL)
                .contains(HintView.STRIKE);
    }

    @DisplayName("ball이 1, strike가 2이면 HintView.BALL, STRIKE 둘 다 렌더링한다.")
    @Test
    void renderBallAndStrikeCount() {
        // given
        final int ballCount = 1;
        final int strikeCount = 2;
        final GameResult result = new GameResult(ballCount, strikeCount);
        final HintView view = new HintView(result);

        // when
        final String renderedString = view.renderToString();

        // then
        assertThat(renderedString)
                .contains(HintView.BALL)
                .contains(HintView.STRIKE);
    }
}