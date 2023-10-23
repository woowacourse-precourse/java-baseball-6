package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.application.BaseBallResult;
import baseball.application.GameUseCase;
import baseball.domain.BaseBallNumberList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGameControllerTest {

    @Test
    @DisplayName("Result에 2스트라이크가 있을 시 2스트라이크 스트링을 반환한다")
    public void should_returnTwoStrikeString_when_gameRuleReturnTwoStrikeResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(2, 0)));
        String result = controller.play("123");
        assertThat(result).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("Result에 1스트라이크가 있을 시 1스트라이크 스트링을 반환한다")
    public void should_returnOneStrikeString_when_gameRuleReturnOneStrikeResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(1, 0)));
        String result = controller.play("123");
        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("Result에 3스트라이크가 있을 시 3스트라이크 스트링을 반환한다")
    public void should_returnThreeStrikeString_when_gameRuleReturnThreeStrikeResult() {
        BaseBallGameController controller = new BaseBallGameController(
                new TestBaseBallGameUseCase(new BaseBallResult(3, 0)));
        String result = controller.play("123");
        assertThat(result).isEqualTo("3스트라이크");
    }

    static class TestBaseBallGameUseCase implements GameUseCase {

        private final BaseBallResult baseBallResult;

        public TestBaseBallGameUseCase(BaseBallResult baseBallResult) {
            this.baseBallResult = baseBallResult;
        }

        @Override
        public BaseBallResult execute(BaseBallNumberList playerInput) {
            return baseBallResult;
        }
    }
}
