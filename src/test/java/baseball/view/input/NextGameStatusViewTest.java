package baseball.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class NextGameStatusViewTest {

    @DisplayName("렌더링 된 NextGameStatusView는 INPUT_NEXT_GAME_STATUS_MESSAGE를 포함한다.")
    @Test
    void renderedNextGameStatusViewTest() {
        // given
        final NextGameStatusView view = new NextGameStatusView();

        // when
        final String renderedView = view.renderToString();

        // then
        assertThat(renderedView)
                .contains(NextGameStatusView.INPUT_NEXT_GAME_STATUS_MESSAGE);
    }

}