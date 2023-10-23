package baseball.domain;

import baseball.strategy.DuplicateAllowancePolicy;
import baseball.strategy.NumberGeneratePolicy;

public class Rule {

    private final NumberGeneratePolicy numberGeneratePolicy;
    private final DuplicateAllowancePolicy duplicateAllowancePolicy;

    public Rule(NumberGeneratePolicy numberGeneratePolicy, DuplicateAllowancePolicy duplicateAllowancePolicy) {
        this.numberGeneratePolicy = numberGeneratePolicy;
        this.duplicateAllowancePolicy = duplicateAllowancePolicy;
    }

    public int generateNumber() {
        return numberGeneratePolicy.generate();
    }

    public boolean canNotBeDuplicated() {
        return !duplicateAllowancePolicy.canBeDuplicated();
    }

}
