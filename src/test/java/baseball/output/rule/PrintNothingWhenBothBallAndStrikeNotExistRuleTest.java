package baseball.output.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.PrintOutputTest;
import baseball.game.BallAndStrike;
import org.junit.jupiter.api.Test;

public class PrintNothingWhenBothBallAndStrikeNotExistRuleTest extends PrintOutputTest {
    @Test
    void 볼과_스트라이크가_모두_없을시_낫싱_출력() {
        final PrintNothingWhenBothBallAndStrikeNotExistRule rule = new PrintNothingWhenBothBallAndStrikeNotExistRule(
                new BallAndStrike(0, 0)
        );
        rule.print();assertThat(output()).contains("낫싱");
    }

    @Test
    void 볼이_있을시_아무것도_출력하지_않음() {
        final PrintNothingWhenBothBallAndStrikeNotExistRule rule = new PrintNothingWhenBothBallAndStrikeNotExistRule(
                new BallAndStrike(1, 0)
        );
        rule.print();
        assertThat(output()).isEmpty();
    }

    @Test
    void 스트라이크가_있을시_아무것도_출력하지_않음() {
        final PrintNothingWhenBothBallAndStrikeNotExistRule rule = new PrintNothingWhenBothBallAndStrikeNotExistRule(
                new BallAndStrike(0, 1)
        );
        rule.print();
        assertThat(output()).isEmpty();
    }
}
