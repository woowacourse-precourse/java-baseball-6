package baseball.output.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.PrintOutputTest;
import baseball.game.BallAndStrike;
import org.junit.jupiter.api.Test;

public class PrintSplitWhenBallAndStrikeExistRuleTest extends PrintOutputTest {
    @Test
    void 볼과_스트라이크가_모두_있을시_공백_출력() {
        final PrintSplitWhenBallAndStrikeExistRule rule = new PrintSplitWhenBallAndStrikeExistRule(
                new BallAndStrike(1, 1)
        );
        rule.print();
        assertThat(output()).contains(" ");
    }

    @Test
    void 볼이_없을시_공백_출력하지_않음() {
        final PrintSplitWhenBallAndStrikeExistRule rule = new PrintSplitWhenBallAndStrikeExistRule(
                new BallAndStrike(0, 1)
        );
        rule.print();
        assertThat(output()).isEmpty();
    }

    @Test
    void 스트라이크가_없을시_공백_출력하지_않음() {
        final PrintSplitWhenBallAndStrikeExistRule rule = new PrintSplitWhenBallAndStrikeExistRule(
                new BallAndStrike(1, 0)
        );
        rule.print();
        assertThat(output()).isEmpty();
    }
}
