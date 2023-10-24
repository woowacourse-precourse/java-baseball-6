package baseball.output.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.PrintOutputTest;
import org.junit.jupiter.api.Test;

public class PrintNewLineRuleTest extends PrintOutputTest {
    @Test
    void 개행_출력() {
        final PrintNewLineRule rule = new PrintNewLineRule();
        rule.print();
        assertThat(output()).contains("\n");
    }
}
