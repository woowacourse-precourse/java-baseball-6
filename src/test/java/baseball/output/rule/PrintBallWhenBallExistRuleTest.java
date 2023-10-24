package baseball.output.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.BallAndStrike;
import baseball.output.BaseBallResultOutput;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PrintBallWhenBallExistRuleTest extends NsTest {
    @Test
    void 볼이_없을때_출력하지_않음() {
        final PrintBallWhenBallExistRule rule = new PrintBallWhenBallExistRule(new BallAndStrike(0, 0));
        rule.print();
        assertThat(output()).isEmpty();
    }

    @Test
    void 볼이_있을때_볼_수를_출력() {
        final PrintBallWhenBallExistRule rule = new PrintBallWhenBallExistRule(new BallAndStrike(1, 0));
        rule.print();
        assertThat(output()).contains("1볼");
    }
    @Override
    public void runMain() {
        // Empty
    }
}
