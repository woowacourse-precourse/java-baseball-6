package baseball.domain;

import baseball.strategy.DuplicateAllowancePolicy;
import baseball.strategy.DigitPolicy;
import baseball.strategy.NumberGeneratePolicy;

public class Rule {

    private final NumberGeneratePolicy numberGeneratePolicy;
    private final DuplicateAllowancePolicy duplicateAllowancePolicy;
    private final DigitPolicy digitPolicy;

    public Rule(
            NumberGeneratePolicy numberGeneratePolicy,
            DuplicateAllowancePolicy duplicateAllowancePolicy,
            DigitPolicy digitPolicy
    ) {
        this.numberGeneratePolicy = numberGeneratePolicy;
        this.duplicateAllowancePolicy = duplicateAllowancePolicy;
        this.digitPolicy = digitPolicy;
    }

    public int generateNumber() {
        return numberGeneratePolicy.generate();
    }

    public boolean canNotBeDuplicated() {
        return !duplicateAllowancePolicy.canBeDuplicated();
    }

    public int digits() {
        return digitPolicy.digits();
    }

}
