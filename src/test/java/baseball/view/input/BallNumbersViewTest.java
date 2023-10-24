package baseball.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class BallNumbersViewTest {

    @DisplayName("게임을 시작할 때, 첫 렌더링 된 BallNumbersView는 GAME_START_MESSAGE를 포함한다.")
    @Test
    void renderedViewContainsStartMessageWhenIsStart() {
        // given
        final BallNumbersView view = new BallNumbersView(true);

        // when
        final String renderedView = view.renderToString();

        // then
        assertThat(renderedView)
                .contains(
                        BallNumbersView.GAME_START_MESSAGE,
                        BallNumbersView.INPUT_BALL_NUMBER_MESSAGE
                );
    }

    @DisplayName("첫 이후, 렌더링 된 BallNumbersView는 GAME_START_MESSAGE를 포함하지 않는다.")
    @Test
    void renderedViewNotContainsStartMessageWhenIsNotStart() {
        // given
        final BallNumbersView view = new BallNumbersView(false);

        // when
        final String renderedView = view.renderToString();

        // then
        assertThat(renderedView)
                .contains(BallNumbersView.INPUT_BALL_NUMBER_MESSAGE)
                .doesNotContain(BallNumbersView.GAME_START_MESSAGE);
    }

   
}