package baseball.output;

import baseball.output.rule.PrintBaseBallResultOutputRule;
import java.util.List;

public class BaseBallResultOutput {
    private final List<PrintBaseBallResultOutputRule> rules;

    public BaseBallResultOutput(final List<PrintBaseBallResultOutputRule> rules) {
        this.rules = rules;
    }

    public void printAllRules() {
        rules.stream().forEach(PrintBaseBallResultOutputRule::print);
    }
}
