package baseball.output.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.PrintOutputTest;
import baseball.game.BallAndStrike;
import org.junit.jupiter.api.Test;

public class PrintStrikeWhenStrikeExistRuleTest extends PrintOutputTest {
    @Test
    void 스트라이크가_있을시_스트라이크를_붙이기() {
        final PrintStrikeWhenStrikeExistRule rule = new PrintStrikeWhenStrikeExistRule(
                new BallAndStrike(0, 1)
        );
        rule.print();
        assertThat(output()).contains("1스트라이크");
    }

    @Test
    void 스트라이크_없을시_공백_출력하지_않음() {
        final PrintSplitWhenBallAndStrikeExistRule rule = new PrintSplitWhenBallAndStrikeExistRule(
                new BallAndStrike(0, 0)
        );
        rule.print();
        assertThat(output()).isEmpty();
    }
}
