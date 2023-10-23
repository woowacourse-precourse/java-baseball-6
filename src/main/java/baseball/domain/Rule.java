package baseball.domain;

import baseball.strategy.DuplicateAllowancePolicy;
import baseball.strategy.NumberDigitPolicy;
import baseball.strategy.NumberGeneratePolicy;

public class Rule {

    private final NumberGeneratePolicy numberGeneratePolicy;
    private final DuplicateAllowancePolicy duplicateAllowancePolicy;
    private final NumberDigitPolicy numberDigitPolicy;

    public Rule(NumberGeneratePolicy numberGeneratePolicy, DuplicateAllowancePolicy duplicateAllowancePolicy, NumberDigitPolicy numberDigitPolicy) {
        this.numberGeneratePolicy = numberGeneratePolicy;
        this.duplicateAllowancePolicy = duplicateAllowancePolicy;
        this.numberDigitPolicy = numberDigitPolicy;
    }

    public int generateNumber() {
        return numberGeneratePolicy.generate();
    }

    public boolean canNotBeDuplicated() {
        return !duplicateAllowancePolicy.canBeDuplicated();
    }

    public int digits() {
        return numberDigitPolicy.digits();
    }

}
