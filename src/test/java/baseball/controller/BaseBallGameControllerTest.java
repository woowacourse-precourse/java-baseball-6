package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.application.BaseBallResult;
import baseball.application.GameUseCase;
import baseball.controller.dto.BaseBallGameDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGameControllerTest {

    @Test
    @DisplayName("Result에 2스트라이크가 있을 시 2스트라이크 스트링을 반환한다")
    public void should_returnTwoStrikeString_when_gameRuleReturnTwoStrikeResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(2, 0)));
        String result = controller.play(new BaseBallGameDto("123"));
        assertThat(result).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("Result에 1스트라이크가 있을 시 1스트라이크 스트링을 반환한다")
    public void should_returnOneStrikeString_when_gameRuleReturnOneStrikeResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(1, 0)));
        String result = controller.play(new BaseBallGameDto("123"));
        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("Result에 3스트라이크가 있을 시 3스트라이크 스트링을 반환한다")
    public void should_returnThreeStrikeString_when_gameRuleReturnThreeStrikeResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(3, 0)));
        String result = controller.play(new BaseBallGameDto("123"));
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("Result에 3볼이 있을 시 3볼 스트링을 반환한다")
    public void should_returnThreeBallString_when_gameRuleReturnThreeBallResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(0, 3)));
        String result = controller.play(new BaseBallGameDto("123"));
        assertThat(result).isEqualTo("3볼");
    }

    @Test
    @DisplayName("Result에 3볼이 있을 시 3볼 스트링을 반환한다")
    public void should_returnTwoBallString_when_gameRuleReturnTwoBallResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(0, 2)));
        String result = controller.play(new BaseBallGameDto("123"));
        assertThat(result).isEqualTo("2볼");
    }

    @Test
    @DisplayName("Result에 1볼이 있을 시 1볼 스트링을 반환한다")
    public void should_returnOneBallString_when_gameRuleReturnOneBallResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(0, 1)));
        String result = controller.play(new BaseBallGameDto("123"));
        assertThat(result).isEqualTo("1볼");
    }

    @Test
    @DisplayName("Result에 볼과 스트라이가 없을 시 낫싱 을 반환한다")
    public void should_returnNothingString_when_gameRuleReturnZeroStrikeAndZeroBallResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(0, 0)));
        String result = controller.play(new BaseBallGameDto("123"));
        assertThat(result).isEqualTo("낫싱");
    }

    static class TestBaseBallGameUseCase implements GameUseCase {

        private final BaseBallResult baseBallResult;

        public TestBaseBallGameUseCase(BaseBallResult baseBallResult) {
            this.baseBallResult = baseBallResult;
        }

        @Override
        public BaseBallResult umpire(NumericString playerInput) {
            return baseBallResult;
        }
    }
}
