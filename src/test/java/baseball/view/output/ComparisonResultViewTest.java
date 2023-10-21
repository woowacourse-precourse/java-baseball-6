package baseball.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.dto.ComparisonResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComparisonResultViewTest {

    private static final ComparisonResultView VIEW = new ComparisonResultView();

    @Test
    @DisplayName("스트라이크만 있을 때 결과를 출력 메세지로 바꿀 수 있다")
    void changeToOutputMessageTest_whenOnlyStrike() {
        ComparisonResult result = new ComparisonResult(2, 0, false);
        String expected = "2스트라이크";

        String actual = VIEW.changeToOutputMessage(result);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("볼만 있을 때 결과를 출력 메세지로 바꿀 수 있다")
    void changeToOutputMessageTest_whenOnlyBall() {
        ComparisonResult result = new ComparisonResult(0, 3, false);
        String expected = "3볼";

        String actual = VIEW.changeToOutputMessage(result);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("볼, 스트라이크 모두 있을 때 결과를 출력 메세지로 바꿀 수 있다")
    void changeToOutputMessageTest_whenStrikeAndBall() {
        ComparisonResult result = new ComparisonResult(2, 1, false);
        String expected = "1볼 2스트라이크";

        String actual = VIEW.changeToOutputMessage(result);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전부 일치하지 않을 때 결과를 출력 메세지로 바꿀 수 있다")
    void changeToOutputMessageTest_whenNothing() {
        ComparisonResult result = new ComparisonResult(0, 0, false);
        String expected = "낫싱";

        String actual = VIEW.changeToOutputMessage(result);

        assertThat(actual).isEqualTo(expected);
    }
}
